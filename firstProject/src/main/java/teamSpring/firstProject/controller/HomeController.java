package teamSpring.firstProject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import teamSpring.firstProject.domain.User;
import teamSpring.firstProject.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class HomeController {

    final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("sessionId")
    public String sessionId(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (String) session.getAttribute("sessionId");
    }

    @ModelAttribute("empName")
    public String empName(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String sessionId = (String) session.getAttribute("sessionId");
        return userService.sessionGetEmpName(Integer.parseInt(sessionId));
    }



    /**
     * メイン画面Controller
     */
    @RequestMapping(value = "/spring", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {

        /**
         * メイン画面の安否登録フォームでdi_idを持てるための処理
         */
        Map<String, Object> latestDisaster = userService.getLatestDisaster();
        Integer disasterId = (Integer) latestDisaster.get("disasterId");
        model.addAttribute("disasterId", disasterId);


        List<Map<String, Object>> mainLatestDisaster = userService.getMainLatestDisaster();
//        List<Object> list = new ArrayList<>(mainLatestDisaster.values());
        model.addAttribute("mainLatestDisaster", mainLatestDisaster);


        HttpSession session = request.getSession();
        String sessionId = (String) session.getAttribute("sessionId");
        log.info("sessionId={}", sessionId);

        List<Map<String, Object>> reportTable = userService.getReportTable();
        model.addAttribute("reportTable", reportTable);
        log.info("reportTable={}", reportTable);
        /**
         * セッションから持ってきて管理者がユーザーを登録してからまた登録できるようにする
         */
        model.addAttribute("sessionId", sessionId);
        String empName = userService.sessionGetEmpName(Integer.parseInt(sessionId));
        log.info("empName={}", empName);

        model.addAttribute("empName", empName);

//        ModelAndView mav = new ModelAndView();
//        mav.addObject("sessionId", sessionId);
//        mav.addObject("empName", empName);
//        mav.setViewName("userSafetyDetail");
//        mav.setViewName("safetyTable");
        return "home";
    }


    /**
     * 管理者がユーザを登録をする画面
     */
    @RequestMapping(value = "/userRegister", method = RequestMethod.GET)
    public String userRegister() {
        return "userRegisterForm";
    }

    @RequestMapping(value = "/userRegister", method = RequestMethod.POST)
    public String userRegister(@ModelAttribute("user") User user) {
        userService.userRegister(user);
        log.info("User={}", user);
        return "redirect:/spring";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact(Model model) {
        Map<String, Object> latestDisaster = userService.getLatestDisaster();
        Integer disasterId = (Integer) latestDisaster.get("disasterId");
        model.addAttribute("disasterId", disasterId);
        return "contact";
    }
}
