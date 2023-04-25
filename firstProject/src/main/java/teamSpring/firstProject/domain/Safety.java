package teamSpring.firstProject.domain;

import lombok.Data;

@Data
public class Safety {
    private String authority; // 部署
    private String employeeName;
    private String safety;  // "o", "x", "-"
}
