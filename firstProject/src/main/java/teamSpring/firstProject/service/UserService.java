package teamSpring.firstProject.service;

import org.springframework.stereotype.Service;
import teamSpring.firstProject.dao.UserDao;
import teamSpring.firstProject.domain.User;

import java.util.List;
import java.util.Map;


@Service
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    // インタペースのメソッドの名前とMapperのidの名前と一緒じゃないとバグる
    public List<Map<String, Object>> users() throws Exception {
        return userDao.users();
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }
}
