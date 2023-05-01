package teamSpring.firstProject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import teamSpring.firstProject.service.UserService;

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
    public String employeeDetail(@PathVariable Integer empId, Model model) {
        log.info("employeeID={}", empId);
        List<Map<String, Object>> userSafetyDetail = userService.getUserSafetyDetail(empId);
        log.info("userSafetyDetail={}", userSafetyDetail);
        Object safety = userSafetyDetail.get(0).get("other_information");
        log.info("other_Information={}", safety);

        model.addAttribute("userSafetyDetail", userSafetyDetail);

        return "userSafetyDetail";
    }
}
