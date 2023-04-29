package teamSpring.firstProject.domain;

import lombok.Data;
import lombok.ToString;

@Data @ToString
public class User {
    private Integer id;
    private String pwd;
    private String name;

    /**
     * 管理者がユーザーを登録する時のための追加
     */
    private String cellphone;
    private Integer departmentId;
}