package teamSpring.firstProject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;

import org.springframework.stereotype.Repository;
import teamSpring.firstProject.domain.Safety;
import teamSpring.firstProject.domain.SafetyFormData;
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
    public User selectUser(Integer employeeId) {
        return sqlSession.selectOne(namespace + "selectUser", employeeId);
    }

    @Override
    public List<Safety> getSafetyTable(Map<String, Object> search) {
        return sqlSession.selectList(namespace + "getSafetyTable", search);
    }

    @Override
    public List<Integer> departmentIdList() {
        return sqlSession.selectList(namespace + "departmentIdList");
    }

    @Override
//    public List<Map<String, Object>> SafetyCheckOK(List<Integer> departmentIdList) {
    public List<Map<String, Object>> safetyCheckOK(List<Integer> departmentIdList) {
        return sqlSession.selectList(namespace + "safetyCheckOK", departmentIdList);
    }

    @Override
    public List<Map<String, Object>> departmentAllEmployees(List<Integer> departmentIdList) {
        return sqlSession.selectList(namespace + "departmentAllEmployees", departmentIdList);
    }

    @Override
    public void safetyRegistration(SafetyFormData safetyFormData) {
        sqlSession.insert(namespace + "safetyRegistration", safetyFormData);
    }

    @Override
    public List<String> departmentNameList() {
        return sqlSession.selectList(namespace + "departmentNameList");
    }

    @Override
    public List<Map<String, Object>> reportTable() {
        return sqlSession.selectList(namespace + "reportTable");
    }

    @Override
    public void registerDisaster(String disaster) {
        sqlSession.insert(namespace + "registerDisaster", disaster);
    }

    @Override
    public void userRegister(User user) {
        sqlSession.insert(namespace + "userRegister", user);
    }

    @Override
    public List<Map<String, Object>> userSafetyDetail(Integer empId) {
        return sqlSession.selectList(namespace + "userSafetyDetail", empId);
    }

    @Override
    public String sessionGetEmpName(int sessionId) {
        return sqlSession.selectOne(namespace + "sessionGetEmpName", sessionId);
    }
}
