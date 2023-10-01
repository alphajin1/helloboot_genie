package geniespring.config.autoconfig;

import geniespring.config.ConditionalMyOnClass;
import geniespring.config.MyAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

// @MyAutoConfiguration ->
// ImportSelector 와 같이 맞춰주자.
// 이걸 부여하지 않는다고 해서, 안되는 건 아니야! 그러나 관례이다.
@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {
    @Bean("TomcatWebServerFactory")
    @ConditionalOnMissingBean // 이미 등록된 것이 없을 떄에만 등록할 것 (Type 인듯?)
    public ServletWebServerFactory servletWebServerFactory(Environment env) {

        // TomcatServletContainer
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.setContextPath(env.getProperty("contextPath"));
        return factory;
    }

}
