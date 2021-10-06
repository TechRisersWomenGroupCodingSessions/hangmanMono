package hangmanMono.com.example.hangmanMono.api;

import hangmanMono.com.example.hangmanMono.model.Game;
import hangmanMono.com.example.hangmanMono.model.Guess;
import hangmanMono.com.example.hangmanMono.model.StartGameRequest;
import hangmanMono.com.example.hangmanMono.model.StartGameResponse;
import hangmanMono.com.example.hangmanMono.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/start")
    public StartGameResponse startTheGame (@RequestBody StartGameRequest startGameRequest) {
        return gameService.startTheGame(startGameRequest);
    }

    @PostMapping("/guess")
    public Game guess (@RequestBody Guess guess) {
        return gameService.guess(guess);
    }
}
