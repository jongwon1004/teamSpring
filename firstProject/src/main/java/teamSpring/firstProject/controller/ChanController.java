package teamSpring.firstProject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teamSpring.firstProject.domain.PrivateUser;
import teamSpring.firstProject.domain.User;
import teamSpring.firstProject.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
//@CrossOrigin(origins = "http://localhost:1234", allowedHeaders = "*", allowCredentials = "true")
public class ChanController {

    final
    UserService userService;

    public ChanController(UserService userService) {
        this.userService = userService;
    }

    /*

        public class PrivateUser {

            private Integer id;
            private String pass;

        }

     */

    @PostMapping("/api/test2")
    public ResponseEntity<?> hello(@RequestBody PrivateUser user, HttpServletResponse response) throws Exception {

        log.info("user={}", user);

        // 쿼리로 찾아온 유저
        PrivateUser resultUser = userService.privateSelectUser(user.getId());
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map<String, Object> result = new HashMap<>();

        // 검증
        if (!user.getPass().equals(resultUser.getPass())) {
            result.put("result", "LoginFail");
            return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).body(result);
        }

        result.put("result", "LoginSuccess");

        return ResponseEntity.ok(result);
    }

    @GetMapping("/api/test3")
    public ResponseEntity<?> hello2() throws Exception {
        return ResponseEntity.ok("Connection Success");
    }

    @GetMapping("/api/test4")
    public ResponseEntity<?> getUsers (HttpServletResponse response) throws Exception {
        List<Map<String, Object>> users = userService.users();
        response.setHeader("Access-Control-Allow-Origin", "*");
        log.info("users={}", users);
        return ResponseEntity.ok(users);
    }


}