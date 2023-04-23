package teamSpring.firstProject.dao;

import org.apache.ibatis.annotations.Mapper;
import teamSpring.firstProject.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<Map<String, Object>> users();

    void addUser(User user);

//    User searchUser(Integer userId);

    User selectUser(Integer userId);
}
