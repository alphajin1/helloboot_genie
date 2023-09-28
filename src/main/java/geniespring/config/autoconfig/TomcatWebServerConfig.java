package geniespring.config.autoconfig;

import geniespring.config.ConditionalMyOnClass;
import geniespring.config.MyAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {
    @Bean("TomcatWebServerFactory")
    @ConditionalOnMissingBean // 이미 등록된 것이 없을 떄에만 등록할 것 (Type 인듯?)
    public ServletWebServerFactory servletWebServerFactory() {

        return new TomcatServletWebServerFactory();
    }

}
