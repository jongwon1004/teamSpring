package teamSpring.firstProject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import teamSpring.firstProject.service.UserService;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class Test2 {

    @Autowired
    UserService userService;

    @Test
    public void testUsers() throws Exception {
        List<Map<String, Object>> users = userService.users();
        System.out.println("users = " + users);
    }
}
