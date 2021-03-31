package hangmanMono.com.example.hangmanMono.api;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
@EnableAutoConfiguration
public class NameController {

    @RequestMapping("/name")
    @ResponseBody
    public UUID getID() {
        // the application is running on http://localhost:8080/name
        return UUID.randomUUID();
    }
}
