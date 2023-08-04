//package teamSpring.firstProject;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import teamSpring.firstProject.dao.ExcelResultDaoImpl;
//import teamSpring.firstProject.domain.ExcelResult;
//import teamSpring.firstProject.domain.Safety;
//import teamSpring.firstProject.domain.SafetyFormData;
//import teamSpring.firstProject.service.UserService;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Random;
//
//
//@SpringBootTest
//public class Test {
//
//    @Autowired
//    UserService userService;
//
//    @org.junit.jupiter.api.Test
//    void test() throws Exception {
//        userService.getLatestDiIdSafetyTable();
//    }
//
//    /**
//     * Excel 出力テースト
//     */
//    @org.junit.jupiter.api.Test
//    void test2() throws Exception {
//        List<ExcelResult> excel = userService.getExcel();
//        ExcelResultDaoImpl excelResultDao = new ExcelResultDaoImpl();
//
//        excelResultDao.createExcel(excel);
//    }
//
//    /**
//     * 全社員の安否登録をするテストコード
//     */
//    @org.junit.jupiter.api.Test
//    void insertAllEmpSafetyInformation() throws Exception{
//        List<Map<String, Object>> users = userService.users();
//        Map<String, Object> latestDisaster = userService.getLatestDisaster();
//        Object di_id = latestDisaster.get("di_id");
//        System.out.println(di_id);
//
//        for(int i = 0; i < users.size(); i++) {
//            SafetyFormData safetyFormData = new SafetyFormData();
//
//            safetyFormData.setEmployeeId((Integer) users.get(i).get("e_id"));
//            String[] options = {"o", "x"};
//            String randomOption = options[new Random().nextInt(options.length)];
//            safetyFormData.setSaOrDa(randomOption);
//            safetyFormData.setInjured(true);
//            safetyFormData.setWorking(true);
//            safetyFormData.setOtherInfo("tasukete!!!!!!!!!!!!!");
//            safetyFormData.setDisasterId((Integer) di_id);
//            userService.getSafetyRegistration(safetyFormData);
//        }
//    }
//
//    /**
//     * DELETE FROM safety_report
//     *               WHERE e_id IN (2220501, 2220502, 2220503, 2220504,
//     *                              3127532, 8933124, 6148244, 6148245,
//     *                              6148246, 1487192, 8933125, 2512831,
//     *                              2512832, 2512833, 2512834, 2512835,
//     *                              1487193, 1487194,2220025,4254963)
//     *  일부 삭제
//     */
//
//}
