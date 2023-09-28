package geniespring.config;

import geniespring.config.autoconfig.DispatcherServletConfig;
import geniespring.config.autoconfig.TomcatWebServerConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) // TYPE 으로 하면 3가지가 적용 됨, Class, interface (including annotation interface), enum, or record declaration
@Import({DispatcherServletConfig.class, TomcatWebServerConfig.class}) // 따로 있는 구성 정보를 추가 시킨다.
public @interface EnableMyAutoConfiguration {
}
