package geniespring.config.autoconfig;

import geniespring.config.ConditionalMyOnClass;
import geniespring.config.MyAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {
    @Bean("TomcatWebServerFactory")
    public ServletWebServerFactory servletWebServerFactory() {

        return new TomcatServletWebServerFactory();
    }

}
