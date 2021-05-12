package hangmanMono.com.example.hangmanMono.api;

import hangmanMono.com.example.hangmanMono.model.Guess;
import hangmanMono.com.example.hangmanMono.model.ResponseToGuess;
import hangmanMono.com.example.hangmanMono.model.StartGame;
import hangmanMono.com.example.hangmanMono.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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
    public StartGame startTheGame () {
        return gameService.startTheGame();
    }

    @PostMapping("/guess")
    public ResponseToGuess guess (@RequestBody Guess guess) {
        return gameService.guess(guess);
    }
}
