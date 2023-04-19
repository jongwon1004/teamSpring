package teamSpring.firstProject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;

import org.springframework.stereotype.Repository;
import teamSpring.firstProject.domain.User;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public class UserDaoImpl implements UserDao {

    private final SqlSession sqlSession;

    private static final String namespace = "teamSpring.firstProject.dao.UserDao.";

    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }


    @Override
    public List<Map<String, Object>> users() {
        return sqlSession.selectList(namespace + "users");
    }

    @Override
    public void addUser(User user) {
        sqlSession.insert(namespace + "addUser", user);
    }

    @Override
    public User searchUser(Integer userId) {
        return sqlSession.selectOne(namespace + "searchUser",userId);
    }
}
