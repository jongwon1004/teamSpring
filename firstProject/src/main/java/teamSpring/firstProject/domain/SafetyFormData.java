package teamSpring.firstProject.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * safetyTable
 */
@Data @ToString @NoArgsConstructor
public class SafetyFormData {
    private Integer safetyId;  // s_id      //Auto Increment
    private Integer employeeId; // e_id
    private String saOrDa; // safety  "o","x","-" default = "-"   // saOrDa -> safetyOrDangerous
    private boolean injured; // injury_flag
    private boolean working; // work_flag
    private String otherInfo; // other_information
    private Date reportDate; // date_of_report      // Now()
}

/**
 * +-------------------+------------+------+-----+-------------------+-------------------+
 * | Field             | Type       | Null | Key | Default           | Extra             |
 * +-------------------+------------+------+-----+-------------------+-------------------+
 * | s_id              | int        | NO   | PRI | NULL              | auto_increment    |
 * | e_id              | int        | NO   | MUL | NULL              |                   |
 * | safety            | varchar(1) | NO   |     | -                 |                   |
 * | injury_flag       | tinyint(1) | NO   |     | 0                 |                   |
 * | work_flag         | tinyint(1) | NO   |     | 1                 |                   |
 * | other_information | text       | YES  |     | NULL              |                   |
 * | date_of_report    | datetime   | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
 * +-------------------+------------+------+-----+-------------------+-------------------+
 */
