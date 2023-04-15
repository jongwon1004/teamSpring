package teamSpring.firstProject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class HelloController {

    @ResponseBody
    @RequestMapping(value = "/hello")
    public String helloTest(HttpServletRequest request) {
        log.info("URL={}",request.getRequestURL());
        return "ok";
    }
}
