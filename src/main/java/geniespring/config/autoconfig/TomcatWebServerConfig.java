package geniespring.config.autoconfig;

import geniespring.config.ConditionalMyOnClass;
import geniespring.config.EnableMyConfigurationProperties;
import geniespring.config.MyAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

// @MyAutoConfiguration ->
// ImportSelector 와 같이 맞춰주자.
// 이걸 부여하지 않는다고 해서, 안되는 건 아니야! 그러나 관례이다.
@MyAutoConfiguration
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
@EnableMyConfigurationProperties(ServerProperties.class)
public class TomcatWebServerConfig {

    // Spring의 기본 기능이 아님. PropertyPlaceholderConfig 추가
    @Bean("TomcatWebServerFactory")
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory(ServerProperties properties) {

        // TomcatServletContainer
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.setContextPath(properties.getContextPath());
        factory.setPort(properties.getPort());
        return factory;
    }

}
