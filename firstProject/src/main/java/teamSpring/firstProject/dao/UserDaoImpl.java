package teamSpring.firstProject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;

import org.springframework.stereotype.Repository;
import teamSpring.firstProject.domain.*;

import java.util.*;

@Mapper
//@Repository
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

    @Override
    public Map<String, Object> latestDisaster() {
        return sqlSession.selectOne(namespace + "latestDisaster");
    }

    @Override
    public List<Map<String, Object>> mainLatestDisaster() {
        return sqlSession.selectList(namespace + "mainLatestDisaster");
    }

    @Override
    public void empDiIdUpdate(Integer disasterId) {
        sqlSession.update(namespace + "empDiIdUpdate", disasterId);
    }

    @Override
    public void latestDiIdSafetyTable() {
        sqlSession.insert(namespace + "latestDiIdSafetyTable");
    }

    @Override
    public List<ExcelResult> excel() {
        return sqlSession.selectList(namespace + "excel");
    }

    @Override
    public void allSafetyTableDataDelete() {
        sqlSession.delete(namespace + "allSafetyTableDataDelete");
    }

    @Override
    public PrivateUser privateSelectUser(Integer employeeId) {
        return sqlSession.selectOne( namespace + "privateSelectUser", employeeId);
    }
}
