package geniespring.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ConfigurationTest {

    @Test
    void configuration1() {
        MyConfig myConfig = new MyConfig();
        Bean1 bean1 = myConfig.bean1();
        Bean2 bean2 = myConfig.bean2();

        // isNotSame !
        Assertions.assertThat(bean1.common).isNotSameAs(bean2.common);
    }

    @Test
    void configuration2() {
        // Configuration 이 붙으면은 Proxy 방식으로 생성되면서, Bean이 싱글톤 레지스트리로 관리됨.
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.register(MyConfig.class);
        ac.refresh();

        Bean1 bean1 = ac.getBean(Bean1.class);
        Bean2 bean2 = ac.getBean(Bean2.class);

        Assertions.assertThat(bean1.common).isSameAs(bean2.common);
    }



    @Test
    void proxyCommonMethod() {
        // 어떻게 Proxy 방식으로 생성되는지 테스트
        MyConfigProxy myConfigProxy = new MyConfigProxy();
        Bean1 bean1 = myConfigProxy.bean1();
        Bean2 bean2 = myConfigProxy.bean2();

        Assertions.assertThat(bean1.common).isSameAs(bean2.common);
    }

    static class MyConfigProxy extends MyConfig {

        private Common common;
        @Override
        Common common() {
            if (this.common == null) this.common = super.common();

            return this.common;
        }

    }

    @Configuration()
//    @Configuration(proxyBeanMethods = false) // 이렇게 할 경우에는 ProxyBean이 설정되지 않아서, ERROR
    static class MyConfig {

        @Bean
        Common common() {
            return new Common();
        }

        @Bean
        Bean1 bean1() {
            return new Bean1(common());
        }

        @Bean
        Bean2 bean2() {
            return new Bean2(common());
        }
    }

    static class Bean1 {
        private final Common common;

        Bean1(Common common) {
            this.common = common;
        }
    }

    static class Bean2 {
        private final Common common;

        Bean2(Common common) {
            this.common = common;
        }
    }

    static class Common {

    }

}
