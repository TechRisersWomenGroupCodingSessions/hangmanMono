package hangmanMono.com.example.hangmanMono;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class HelloWorldController {

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        // the application is running on http://localhost:8080/hello
        return "Hello World!!!";
    }
}
