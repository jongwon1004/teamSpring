package teamSpring.firstProject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import teamSpring.firstProject.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class BoardController {

    final UserService userService;

    public BoardController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/safetyTable/empId/{empId}")
    public String employeeDetail(@PathVariable Integer empId, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        log.info("employeeID={}", empId);
        log.info("request={}", request.getRequestURI());


        /**
         * sessionId check
         */
        HttpSession session = request.getSession();
        String sessionId = (String) session.getAttribute("sessionId");
        log.info("sessionId={}", sessionId);
        model.addAttribute("sessionId", sessionId);

        Map<String, Object> latestDisaster = userService.getLatestDisaster();
        Integer disasterId = (Integer) latestDisaster.get("disasterId");
        model.addAttribute("disasterId", disasterId);

        String empName = userService.sessionGetEmpName(Integer.parseInt(sessionId));
        log.info("empName={}", empName);
        model.addAttribute("empName", empName);
        List<Map<String, Object>> userSafetyDetail = null;

        try {
            userSafetyDetail = userService.getUserSafetyDetail(empId);
            log.info("userSafetyDetail={}", userSafetyDetail);
            Object safety = userSafetyDetail.get(0).get("other_information");
            log.info("other_Information={}", safety);

            model.addAttribute("userSafetyDetail", userSafetyDetail);
        }catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message","NOT_USERINFORMATION");
            return "redirect:/safetyTable";
        }

        return "userSafetyDetail";
    }
}
