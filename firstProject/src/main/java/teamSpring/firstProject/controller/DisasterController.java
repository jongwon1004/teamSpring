package teamSpring.firstProject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import teamSpring.firstProject.dao.ExcelResultDaoImpl;
import teamSpring.firstProject.domain.ExcelResult;
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

        List<ExcelResult> excel = userService.getExcel();
        System.out.println("excel = " + excel);

        ExcelResultDaoImpl excelResultDao = new ExcelResultDaoImpl();

        excelResultDao.createExcel(excel);

        userService.allSafetyTableDataDelete();

        return "redirect:/spring";
    }
}


/**
 * ALTER TABLE orders
 * DROP FOREIGN KEY orders_customer_id_fk;
 *
 * ALTER TABLE orders
 * ADD COLUMN order_status VARCHAR(50);
 */
