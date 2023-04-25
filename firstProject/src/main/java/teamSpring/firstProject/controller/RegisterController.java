package teamSpring.firstProject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import teamSpring.firstProject.domain.User;
import teamSpring.firstProject.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(HttpServletRequest request, @RequestBody User user) {
//        System.out.println("request.getParameter(\"id\") = " + request.getParameter("id"));
        log.info("URI={}", request);
        log.info("USER={}", user);
        userService.addUser(user);
        return "ok";
    }
}
