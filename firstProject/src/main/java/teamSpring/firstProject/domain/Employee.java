package teamSpring.firstProject.domain;

import lombok.Data;

/**
 * @Data
 * Getter, Setter, RequiredArgsConstructor, ToString, EqualsAndHashCode, Value
 */
@Data
public class Employee {
    private Integer employeeId;
    private String employeeName;
    private String password;
    private String Cellphone;
    private Integer departmentId; //　部署 id
    private String authority; // 安否登録可否 - , x , o
}
