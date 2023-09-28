package geniespring.config.autoconfig;
// package 가 다르므로, ComponentScan 대상이 아님

import geniespring.config.MyAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

@MyAutoConfiguration // MetaAnnotation
public class DispatcherServletConfig {

    @Bean
    public DispatcherServlet dispatcherServlet() {

        // 	void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
        return new DispatcherServlet();
    }
}
