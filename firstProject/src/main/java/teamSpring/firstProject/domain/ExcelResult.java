package teamSpring.firstProject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor @AllArgsConstructor
public class ExcelResult {
        private String authority; // 部署
        private String employeeName;
        private String safety;  // "o", "x", "-"
        private LocalDateTime reportDate;
        private Integer employeeId; // 안부표 상세정보 링크걸때 사용하기 위해서 추가
        private Integer disasterId;
        private String injury;
        private String work;
        private String otherInfo;
        private String cellphone;
}
