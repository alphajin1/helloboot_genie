package geniespring.helloboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

// 구성정보를 가진 Class 이니 Spring 에게 알려준다.
// Configuration 이 있으면... 최초에 뭔가 다양한 것을 등록하나 보다?
@Configuration
@ComponentScan
public class HellobootApplication {
    @Bean
    public ServletWebServerFactory servletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }

    @Bean
    public DispatcherServlet dispatcherServlet() {

        // 	void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
        return new DispatcherServlet();
    }

    public static void main(String[] args) {
        SpringApplication.run(HellobootApplication.class, args);
    }


}
