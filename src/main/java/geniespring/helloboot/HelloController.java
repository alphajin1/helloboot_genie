package geniespring.helloboot;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

@RequestMapping("/hello")
@Component
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping
    @ResponseBody
    public String hello(String name) {
        // return Spring 으로 하면, DispacherServlet 은 기본적으로 view 를 찾아서 return 하려함
        // 그래서, @ResponseBody 를 추가해야 함
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
