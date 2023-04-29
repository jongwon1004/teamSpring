package teamSpring.firstProject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import teamSpring.firstProject.domain.User;
import teamSpring.firstProject.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class HomeController {

    final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }


    /**
     * メイン画面Controller
     */
    @RequestMapping(value = "/spring", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        String sessionId = (String) session.getAttribute("sessionId");
        log.info("sessionId={}", sessionId);

        List<Map<String, Object>> reportTable = userService.getReportTable();
        model.addAttribute("reportTable", reportTable);
        /**
         * セッションから持ってきて管理者がユーザーを登録してからまた登録できるようにする
         */
        model.addAttribute("sessionId", sessionId);

        return "home";
    }

    @RequestMapping(value = "/disasterRegister", method = RequestMethod.GET)
    public String disasterRegister() {
        return "/registerForm";
    }

    @ResponseBody
    @RequestMapping(value = "/registerDisaster", method = RequestMethod.POST)
    public String disasterRegister(@RequestParam String disaster) {
        log.info("disaster={}", disaster);
        userService.registerDisaster(disaster);
        return "ok";
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
}
