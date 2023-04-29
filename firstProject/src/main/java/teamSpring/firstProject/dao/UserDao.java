package teamSpring.firstProject.dao;

import teamSpring.firstProject.domain.Safety;
import teamSpring.firstProject.domain.SafetyFormData;
import teamSpring.firstProject.domain.User;

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
}

