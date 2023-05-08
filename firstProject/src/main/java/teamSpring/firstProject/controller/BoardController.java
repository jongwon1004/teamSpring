package teamSpring.firstProject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import teamSpring.firstProject.service.UserService;

import javax.servlet.http.HttpServletRequest;
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
