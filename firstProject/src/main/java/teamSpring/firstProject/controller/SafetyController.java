package teamSpring.firstProject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import teamSpring.firstProject.domain.Safety;
import teamSpring.firstProject.domain.SafetyFormData;
import teamSpring.firstProject.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    /**
     * @param searchType
     * @param searchKeyword
     * @return safetyTable
     */
    @RequestMapping(value = "/safetyTable", method = RequestMethod.GET)
    public String safetyTable (Model model, HttpServletRequest request,
                               @RequestParam(defaultValue = "") String searchType, @RequestParam(defaultValue = "") String searchKeyword) {
        log.info("URI={}", request);

        List<Safety> safetyTable;
        Map<String, Object> search = new HashMap<>();
        search.put("searchType", searchType);
        search.put("keyword", searchKeyword);

        safetyTable = userService.getSafetyTable(search);

//        if ("deptName".equals(searchType)) {  // searchTypeがdeptNameと同じ場合　// deptNameは safetyTable.htmlのformを確認
//            // 部署名で検索
//            safetyTable = userService.getSafetyTable(searchKeyword);
//        } else {
//            // 社員番号で検索
//            safetyTable = userService.searchByEmpNo(searchKeyword);
//        }

        List<String> departmentNameList = userService.getDepartmentNameList();
        model.addAttribute("departmentNameList",departmentNameList);
        model.addAttribute("safetyTable", safetyTable);
        log.info("safetyTable={}", safetyTable);

        List<Integer> departmentIdList = userService.getDepartmentIdList();
        log.info("departmentIdList={}",departmentIdList);

        /**
         * safetyCheckOkは部署の名前と部署の総社員数のデータを持ってくる
         */
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

        return "safetyTable";
    }

    /**
     * @GetMapping("/search")
     * public String searchResult(@RequestParam String searchType, @RequestParam String searchKeyword, Model model){} {
     *
     * }
     */

//    @ResponseBody
    @RequestMapping(value = "/safetyTable2", method = RequestMethod.GET)
    public String safetyTable(Model model) {
//        List<Integer> departmentIdList = userService.getDepartmentIdList();
//        log.info("departmentIdList={}",departmentIdList);
//
//        /**
//         * safetyCheckOkは部署の名前と部署の総社員数のデータを持ってくる
//         */
//        List<Map<String, Object>> safetyCheckOK = userService.getSafetyCheckOK(departmentIdList);
//        List<Map<String, Object>> departmentAllEmployees = userService.departmentAllEmployees(departmentIdList);
//
//        log.info("safetyCheckOK={}", safetyCheckOK);
//        log.info("departmentAllEmployees={}",departmentAllEmployees);
//
//        List<Map<String, Object>> mergedList = new ArrayList<>();
//        for (int i = 0; i < safetyCheckOK.size(); i++) {
//            Map<String, Object> safetyMap = safetyCheckOK.get(i);
//            Map<String, Object> dpEmpsMap = departmentAllEmployees.get(i);
//            Map<String, Object> mergedMap = new HashMap<>();
//            mergedMap.put("departmentName", safetyMap.get("departmentName"));
//            mergedMap.put("safetyCheckCount", safetyMap.get("count"));
//            mergedMap.put("allEmpsCount", dpEmpsMap.get("empCount"));
//            mergedList.add(mergedMap);
//        }
//
//        model.addAttribute("mergedList", mergedList);
        return "safetyTable2";
    }

    @GetMapping("/safetyForm")
    public String safetyForm(Model model, HttpServletRequest request, HttpSession session) {

        /**
         * テストで9999999をセッションを生成する
         */
//        HttpSession session = request.getSession();
//        session.setAttribute("sessionId","9999999");  // adminアカウント
//        String id = (String) session.getAttribute("sessionId");
//        model.addAttribute("sessionId", id);

        return "safetyReportForm";
    }

//    @ResponseBody
    @PostMapping("/safetyForm")
    public String formData(@ModelAttribute("safetyForm") SafetyFormData safetyFormData) {
        log.info("safetyForm={}", safetyFormData);
        userService.getSafetyRegistration(safetyFormData);


        return "redirect:/spring";
    }


}
