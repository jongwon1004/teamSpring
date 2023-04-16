package teamSpring.firstProject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "teamSpring.firstProject")
/**
 * @MapperScan 어노테이션은 MyBatis 에서 Mapper 인터페이스를 자동으로 스캔해서 빈으로 등록해주는 역할이다
 * basePackages 속성에 지정된 패키지를 스캔하여, Mapper 인터페이스를 찾고 이를 스프링의 빈으로 등록한다
 * 이렇게 하면 Mapper 인터페이스를 직접 구현하는 클래스를 생성하지 않고도 MyBatis 에서 자동으로 생성해주는 구현체를 사용할 수 있다.
 * 따라서 @MapperScan 어노테이션을 사용하면 코드의 양을 줄일 수 있으며, Mapper 인터페이스와 구현체 간의 일관성도 높일 수 있다.
 */
public class FirstProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstProjectApplication.class, args);
	}

}
