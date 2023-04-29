package teamSpring.firstProject.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// Thymeleaf의 temporals.format사용할떄 java.util.Date클래스를 사용했을떄 에러가 났다
// java.time.LocalDateTime 이나 java.time.LocalDate 를 사용하니까 에러가 고쳐짐

/**
 * java.util.Date 클래스는 Java 8 이전 버전에서 사용되던 날짜 및 시간을 처리하는 클래스입니다.
 * java.util.Date 클래스는 이미 구식이 되었으며, Java 8에서 새로운 날짜 및 시간 API인 java.time 패키지가 도입되었습니다.
 * Thymeleaf에서 temporals.format 표현식을 사용하려면,
 * java.time 패키지에 있는 java.time.temporal.TemporalAccessor 인터페이스를 구현하는 클래스를 사용해야 합니다.
 * 이 클래스는 temporals.format 메서드를 사용하여 지정된 날짜 형식에 따라 날짜 값을 포맷할 수 있습니다.
 */
@Data @NoArgsConstructor
public class Safety {
    private String authority; // 部署
    private String employeeName;
    private String safety;  // "o", "x", "-"
    private LocalDateTime reportDate;
    private Integer employeeId; // 안부표 상세정보 링크걸때 사용하기 위해서 추가
}



