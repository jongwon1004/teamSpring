package teamSpring.firstProject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import teamSpring.firstProject.domain.Safety;
import teamSpring.firstProject.domain.User;
import teamSpring.firstProject.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @RequestMapping("/members")
    public List<Map<String, Object>> members(HttpServletRequest request) throws Exception {
        log.info("URI={}", request.getRequestURL());
        return userService.users();
    }

    @RequestMapping(value = "/safetyTable", method = RequestMethod.GET)
    public String safetyTable (Model model, HttpServletRequest request) {
        log.info("URI={}", request);
        List<Safety> safetyTable = userService.getSafetyTable();
        model.addAttribute("safetyTable", safetyTable);
        log.info("safetyTable={}", safetyTable);
        return "safetyTable";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request, Model model) {
        log.info("URI={}", request);
        Cookie[] cookies = request.getCookies();
        User user = new User();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("rememberUserId")) {
                    model.addAttribute("rememberUserId", Integer.parseInt(cookie.getValue()));
                    log.info("rememberUserId={}",cookie.getValue());
                    user.setId(Integer.parseInt(cookie.getValue()));
                    break;
                }
            }
        }

        model.addAttribute("user", user);
        return "LoginForm";
    }

    //ログインしてログインした人の情報を表示する
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("user") User user, BindingResult bindingResult, @RequestParam(required = false)boolean rememberId, HttpServletRequest request , HttpServletResponse response, Model model) {
        log.info("URI={}", request);
        log.info("userId={}",user.getId());
        log.info("userPwd={}",user.getPwd());


        User selectUser = userService.selectUser(user.getId());



        log.info("selectUser={}", selectUser);
        if(selectUser == null  || !(user.getId().equals(selectUser.getId()) && user.getPwd().equals(selectUser.getPwd()))) {
            bindingResult.addError(new ObjectError("user","IDまたはPasswordが間違っています"));
        }

        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "LoginForm";
        }
        HttpSession session = request.getSession();
        session.setAttribute("id", user.getId());

        if (rememberId) {
            Cookie cookie = new Cookie("rememberUserId", user.getId().toString());
            cookie.setMaxAge(60 * 60 * 24 * 1); // 쿠키 유효기간을 1일로 설정
            response.addCookie(cookie);
        }

        return "LoginInfo";
    }
}

/**
 * // 쿠키 삭제
 *     Cookie[] cookies = request.getCookies();
 *     if (cookies != null) {
 *         for (Cookie cookie : cookies) {
 *             cookie.setMaxAge(0);
 *             cookie.setPath("/");
 *             response.addCookie(cookie);
 *         }
 *     }
 */

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
