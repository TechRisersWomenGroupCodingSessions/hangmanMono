package hangmanMono.com.example.hangmanMono.api;

import hangmanMono.com.example.hangmanMono.model.Player;
import hangmanMono.com.example.hangmanMono.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@EnableAutoConfiguration
@CrossOrigin("*")
@RequestMapping(path = "api/v1/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public UUID getID() {
        // the application is running on http://localhost:8080/api/v1/player
        return UUID.randomUUID();
    }

    @GetMapping
    public List<Player> getPlayers(){
        return playerService.getPlayers();
    }

}
