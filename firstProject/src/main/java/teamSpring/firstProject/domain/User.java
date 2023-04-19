package teamSpring.firstProject.domain;

import lombok.Data;
import lombok.ToString;

@Data @ToString
public class User {
    private Integer userId;
    private Integer userPwd;
    private String userName;
}
