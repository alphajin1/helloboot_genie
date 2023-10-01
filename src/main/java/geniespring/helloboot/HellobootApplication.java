package geniespring.helloboot;

import geniespring.config.MySpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;

// 구성정보를 가진 Class 이니 Spring 에게 알려준다.
// Configuration 이 있으면... 최초에 뭔가 다양한 것을 등록하나 보다?
@MySpringBootApplication
public class HellobootApplication {


    private final JdbcTemplate jdbcTemplate;

    public HellobootApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct // SpringBoot가 다 뜨고 나서...
    void init() {
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
    }


    public static void main(String[] args) {
        SpringApplication.run(HellobootApplication.class, args);
    }
}
