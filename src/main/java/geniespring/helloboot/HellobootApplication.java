package geniespring.helloboot;

import geniespring.config.MySpringBootApplication;
import org.springframework.boot.SpringApplication;

// 구성정보를 가진 Class 이니 Spring 에게 알려준다.
// Configuration 이 있으면... 최초에 뭔가 다양한 것을 등록하나 보다?
@MySpringBootApplication
public class HellobootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HellobootApplication.class, args);
    }
}
