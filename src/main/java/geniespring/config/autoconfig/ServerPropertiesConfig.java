package geniespring.config.autoconfig;

import geniespring.config.MyAutoConfiguration;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MyAutoConfiguration
public class ServerPropertiesConfig {

    // ServerProperties 는 SpringBoot 도 있음.
    @Bean
    ServerProperties serverProperties(Environment environment) {
        return Binder.get(environment).bind("", ServerProperties.class).get();
    }
}
