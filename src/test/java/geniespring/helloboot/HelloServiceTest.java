package geniespring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloServiceTest {

    @Test
    void simpleHelloService() {
        SimpleHelloService helloService = new SimpleHelloService();
        String ret = helloService.sayHello("Test");

        // LiveTemplate example) asj
        Assertions.assertThat(ret).isEqualTo("Hello Test");
    }
}
