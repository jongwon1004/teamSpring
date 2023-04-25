package teamSpring.firstProject.dao;

import org.apache.ibatis.annotations.Mapper;
import teamSpring.firstProject.domain.Safety;
import teamSpring.firstProject.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<Map<String, Object>> users();

    void addUser(User user);

    User selectUser(Integer userId);

    List<Safety> getSafetyTable();

    List<Integer> departmentIdList();

//    List<Map<String, Object>> SafetyCheckOK(List<Integer> departmentIdList);
    List<Map<String, Object>> safetyCheckOK(List<Integer> departmentIdList);

    List<Map<String, Object>> departmentAllEmployees(List<Integer> departmentIdList);
}

