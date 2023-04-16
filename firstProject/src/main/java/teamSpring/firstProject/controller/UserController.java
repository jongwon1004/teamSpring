package teamSpring.firstProject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
        log.info("URI={}",request.getRequestURL());
        return userService.users();
    }

    @ResponseBody
    @RequestMapping(value = "/addMember", method = RequestMethod.POST)
    public String addMember(HttpServletRequest request) {
        User user = new User();
        user.setId(2222222);
        user.setName("test1");
        user.setPwd(19991004);
        userService.addUser(user);
        log.info("URI={}", request);
        return "ok";
    }

}
