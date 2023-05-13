package teamSpring.firstProject.dao;

import teamSpring.firstProject.domain.ExcelResult;
import teamSpring.firstProject.domain.Safety;
import teamSpring.firstProject.domain.SafetyFormData;
import teamSpring.firstProject.domain.User;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface UserDao {
    List<Map<String, Object>> users();

    void addUser(User user);

    User selectUser(Integer employeeId);

    List<Safety> getSafetyTable(Map<String, Object> search);

    List<Integer> departmentIdList();

    List<Map<String, Object>> safetyCheckOK(List<Integer> departmentIdList);

    List<Map<String, Object>> departmentAllEmployees(List<Integer> departmentIdList);

    void safetyRegistration(SafetyFormData safetyFormData);

    List<String> departmentNameList();

    List<Map<String, Object>> reportTable();

    void registerDisaster(String disaster);

    void userRegister(User user);

    List<Map<String, Object>> userSafetyDetail(Integer empId);

    String sessionGetEmpName(int sessionId);

    Map<String, Object> latestDisaster();

    List<Map<String, Object>> mainLatestDisaster();

    void empDiIdUpdate(Integer disasterId);

    void latestDiIdSafetyTable();

    List<ExcelResult> excel();

    void allSafetyTableDataDelete();

//    void resetSafetyTable();
}

