package teamSpring.firstProject.domain;

import lombok.Data;
import lombok.ToString;

@Data @ToString
public class User {
    private Integer id;
    private Integer pwd;
    private String name;
}
