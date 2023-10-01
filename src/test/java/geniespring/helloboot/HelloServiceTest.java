package geniespring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloServiceTest {

    private static HelloRepository helloRepositoryStub() {
        return new HelloRepository() {
            @Override
            public Hello findHello(String name) {
                return null;
            }

            @Override
            public void increaseCount(String name) {

            }
        };
    }
    @Test
    void simpleHelloService() {
        SimpleHelloService helloService = new SimpleHelloService(helloRepositoryStub());

        String ret = helloService.sayHello("Test");

        // LiveTemplate example) asj
        Assertions.assertThat(ret).isEqualTo("Hello Test");
    }



//    @Test
//    void helloDecorator() {
//        HelloDecorator decorator = new HelloDecorator(name -> name);
//        String ret = decorator.sayHello("Test");
//
//        Assertions.assertThat(ret).isEqualTo("*Test*");
//    }
}
