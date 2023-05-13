package teamSpring.firstProject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import teamSpring.firstProject.service.UserService;

import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class DisasterController {

    final UserService userService;

    public DisasterController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/disasterRegister", method = RequestMethod.GET)
    public String disasterRegister() {
        return "/registerForm";
    }

    @ResponseBody
    @RequestMapping(value = "/disasterRegister", method = RequestMethod.POST)
    public String disasterRegister(@RequestParam String disaster) throws Exception {
        log.info("disaster={}", disaster);
        userService.registerDisaster(disaster);
        Map<String, Object> latestDisaster = userService.getLatestDisaster();

        //　管理者が災害を登録するとdi_idが++してインクリメントしたdi_idの値を持ってくる
        Integer disasterId = (Integer) latestDisaster.get("disasterId");
        log.info("disasterId={}", disasterId);

        // 持ってきたdi_idの値をemployeeテーブルのdi_idにupdate
        userService.empDiIdUpdate(disasterId);

        userService.allSafetyTableDataDelete();

        return "ok";
    }
}


/**
 * ALTER TABLE orders
 * DROP FOREIGN KEY orders_customer_id_fk;
 *
 * ALTER TABLE orders
 * ADD COLUMN order_status VARCHAR(50);
 */
