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

/**
 * @PostMapping("/login")
 *     public String login(String id, String pwd, HttpServletRequest request, HttpServletResponse response, Model m) {
 *         // 1. id와 pwd를 확인
 *         if(!loginCheck(id, pwd)) {
 *             // 일치하지 않으면, loginForm으로 이동
 *             m.addAttribute("msg","IDまたはパスワードが間違っています");
 *             return "redirect:/login/login";
 *         }
 *
 *         // id와 pwd가 일치하면 세션 객체에 id를 저장
 *         HttpSession session = request.getSession();
 *         session.setAttribute("id", id);
 *
 *
 *             // 아이디 기억을 체크하면 쿠키를 생성해줌
 *         if(loginCheck(id, pwd)) {
 *             Cookie cookie = new Cookie("id", id);
 *             response.addCookie(cookie);
 *         }else {
 *             Cookie cookie = new Cookie("id", id);
 *             cookie.setMaxAge(0);
 *             response.addCookie(cookie);
 *         }
 *         return "redirect:/";
 *     }
 *
 *     private boolean loginCheck(String id, String pwd) {
 *         User user = userDao.selectUser(id);
 *         // DB로 유저 검색해서 대조하는것은 나중에 수정하고 일시적으로 지정아이디,비번
 * //        return id.equals("admin") & pwd.equals("dnflwlq1408");
 *         if(user == null)
 *             return false;
 *         return id.equals(user.getId()) && pwd.equals(user.getPwd());
 *     }
 */
