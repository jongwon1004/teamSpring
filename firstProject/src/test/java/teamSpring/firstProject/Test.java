package teamSpring.firstProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import teamSpring.firstProject.dao.ExcelResultDaoImpl;
import teamSpring.firstProject.domain.ExcelResult;
import teamSpring.firstProject.service.UserService;

import java.util.List;
import java.util.Map;


@SpringBootTest
public class Test {

    @Autowired
    UserService userService;


//    @Autowired
//    ExcelResultDaoImpl excelResultDao;

    @org.junit.jupiter.api.Test
    void test() throws Exception {
//        List<Map<String, Object>> users = userService.users();
//        System.out.println("users = " + users);
        userService.getLatestDiIdSafetyTable();

    }

    @org.junit.jupiter.api.Test
    void test2() throws Exception {
        List<ExcelResult> excel = userService.getExcel();
        System.out.println("excel = " + excel);

        ExcelResultDaoImpl excelResultDao = new ExcelResultDaoImpl();

        excelResultDao.createExcel(excel);
    }
}
