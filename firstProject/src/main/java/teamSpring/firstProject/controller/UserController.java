package teamSpring.firstProject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import teamSpring.firstProject.domain.User;
import teamSpring.firstProject.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @RequestMapping("/members")
    public List<Map<String, Object>> members(HttpServletRequest request) throws Exception {
        log.info("URI={}", request.getRequestURL());
        return userService.users();
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request) {
        log.info("URI={}", request);
        return "LoginForm";
    }

    //ログインしてログインした人の情報を表示する
    //@ResponseBody
    @RequestMapping(value = "/loginInfo", method = RequestMethod.POST)
    public String login(@ModelAttribute("user") User user, HttpServletRequest request) {
        log.info("URI={}", request);
        log.info("User={}", user);
        return "LoginInfo";
    }

    @ResponseBody
    @RequestMapping(value = "/searchUser/{userId}", method = RequestMethod.GET)
    public User searchUser(@PathVariable int userId) {
        User user = userService.searchUser(userId);
        log.info("searchUser={}", user);
        return user;
    }
}
