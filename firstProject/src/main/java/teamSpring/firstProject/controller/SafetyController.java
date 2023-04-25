package teamSpring.firstProject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import teamSpring.firstProject.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class SafetyController {

    UserService userService;
    // private final check

    public SafetyController(UserService userService) {
        this.userService = userService;
    }

//    @ResponseBody
    @RequestMapping(value = "/safetyTable2", method = RequestMethod.GET)
    public String safetyTable(Model model) {
        List<Integer> departmentIdList = userService.getDepartmentIdList();
        log.info("departmentIdList={}",departmentIdList);

        List<Map<String, Object>> safetyCheckOK = userService.getSafetyCheckOK(departmentIdList);
        List<Map<String, Object>> departmentAllEmployees = userService.departmentAllEmployees(departmentIdList);

        log.info("safetyCheckOK={}", safetyCheckOK);
        log.info("departmentAllEmployees={}",departmentAllEmployees);

        List<Map<String, Object>> mergedList = new ArrayList<>();
        for (int i = 0; i < safetyCheckOK.size(); i++) {
            Map<String, Object> safetyMap = safetyCheckOK.get(i);
            Map<String, Object> dpEmpsMap = departmentAllEmployees.get(i);
            Map<String, Object> mergedMap = new HashMap<>();
            mergedMap.put("departmentName", safetyMap.get("departmentName"));
            mergedMap.put("safetyCheckCount", safetyMap.get("count"));
            mergedMap.put("allEmpsCount", dpEmpsMap.get("empCount"));
            mergedList.add(mergedMap);
        }

        model.addAttribute("mergedList", mergedList);
        return "safetyTable2";
    }

    @GetMapping("/safetyForm")
    public String index(Model model) {
        model.addAttribute("injured", false);
        model.addAttribute("saOrDa", false);
        model.addAttribute("working", false);
        return "safetyReportForm";
    }
}
