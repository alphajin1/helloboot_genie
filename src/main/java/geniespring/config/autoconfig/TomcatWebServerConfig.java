package geniespring.config.autoconfig;

import geniespring.config.ConditionalMyOnClass;
import geniespring.config.MyAutoConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

// @MyAutoConfiguration ->
// ImportSelector 와 같이 맞춰주자.
// 이걸 부여하지 않는다고 해서, 안되는 건 아니야! 그러나 관례이다.
@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {

    // Spring의 기본 기능이 아님. PropertyPlaceholderConfig 추가
    @Value("${contextPath}")
    String contextPath;

    @Bean("TomcatWebServerFactory")
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory() {

        // TomcatServletContainer
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.setContextPath(contextPath);
        return factory;
    }

}
