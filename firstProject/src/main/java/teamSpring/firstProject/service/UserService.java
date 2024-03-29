package teamSpring.firstProject.service;

import org.springframework.stereotype.Service;
import teamSpring.firstProject.dao.UserDao;
import teamSpring.firstProject.domain.*;

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

    public User selectUser(Integer userId) {
        return userDao.selectUser(userId);
    }

    public List<Safety> getSafetyTable(Map<String, Object> search) {
        return userDao.getSafetyTable(search);
    }

    public List<Integer> getDepartmentIdList() {
        return userDao.departmentIdList();
    }

    public List<Map<String, Object>> getSafetyCheckOK(List<Integer> departmentIdList) {
//    public List<Map<String ,Object>> getSafetyCheckOK(List<Integer> departmentIdList) {
        return userDao.safetyCheckOK(departmentIdList);
    }

    public List<Map<String, Object>> departmentAllEmployees(List<Integer> departmentIdList) {
        return userDao.departmentAllEmployees(departmentIdList);
    }

    public void getSafetyRegistration(SafetyFormData safetyFormData) {
        userDao.safetyRegistration(safetyFormData);
    }

    public List<String> getDepartmentNameList() {
        return userDao.departmentNameList();
    }

    public List<Map<String, Object>> getReportTable() {
        return userDao.reportTable();
    }

    public void registerDisaster(String disaster) {
        userDao.registerDisaster(disaster);
    }

    public void userRegister(User user) {
        userDao.userRegister(user);
    }

    public List<Map<String, Object>> getUserSafetyDetail(Integer empId) {
        return userDao.userSafetyDetail(empId);
    }

    public String sessionGetEmpName(int sessionId) {
        return userDao.sessionGetEmpName(sessionId);
    }

    public Map<String, Object> getLatestDisaster() {
        return userDao.latestDisaster();
    }

    public List<Map<String, Object>> getMainLatestDisaster() {
        return userDao.mainLatestDisaster();
    }

    public void empDiIdUpdate(Integer disasterId) {
        userDao.empDiIdUpdate(disasterId);
    }

    public void getLatestDiIdSafetyTable() {
        userDao.latestDiIdSafetyTable();
    }

    public List<ExcelResult> getExcel() {
        return userDao.excel();
    }

    public void allSafetyTableDataDelete() {
        userDao.allSafetyTableDataDelete();
    }

    public PrivateUser privateSelectUser(Integer employeeId) {
        return userDao.privateSelectUser(employeeId);
    }

//    public void resetSafetyTable() {
//        userDao.resetSafetyTable();
//    }
}
