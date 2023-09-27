package geniespring.helloboot;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary // Bean 이 2개 이상 존재할 때, 가장 먼저 주입됨
public class HelloDecorator implements HelloService {
    private final HelloService helloService; // Primary로 인해, 나머지 SimpleHelloSerivce 가 주입 됨

    public HelloDecorator(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public String sayHello(String name) {
        return "*" + helloService.sayHello(name) + "*";
    }
}
