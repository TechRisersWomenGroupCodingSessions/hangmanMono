package hangmanMono.com.example.hangmanMono.api;

import hangmanMono.com.example.hangmanMono.model.SecretWord;
import hangmanMono.com.example.hangmanMono.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@CrossOrigin("*")
@RequestMapping(path = "api/v1/game")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/start")
    public SecretWord startTheGame () {
        return gameService.startTheGame();
    }

//    @GetMapping("/guess")
//    public SecretWord guess () {
//        return gameService.guess();
//    }
}
