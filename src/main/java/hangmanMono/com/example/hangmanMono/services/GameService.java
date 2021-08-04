package hangmanMono.com.example.hangmanMono.services;

import hangmanMono.com.example.hangmanMono.model.*;
import hangmanMono.com.example.hangmanMono.repository.GameRepository;
import hangmanMono.com.example.hangmanMono.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final PlayerRepository playerRepository;

    @Autowired
    public GameService(GameRepository gameRepository, PlayerRepository playerRepository) {
        this.gameRepository = gameRepository;
        this.playerRepository = playerRepository;
    }


    // TODO Difficult to test because lots of functions in one place and object being passed in
    public ResponseToGuess guess(Guess guess) {


        return null;
    }



    public StartGameResponse startTheGame(StartGameRequest startGameRequest) {
        Long playerId = startGameRequest.getId();
        boolean gameInProgress = startGameRequest.getGameInProgress();

        SecretWordService secretWordService = new SecretWordService();
        String secretWord = secretWordService.getSecretWord();

        Optional<Player> player = playerRepository.findById(playerId);

        if (player.isPresent()){
            ResponseToGuess game = new ResponseToGuess(secretWord, player.get(), gameInProgress);
            gameRepository.save(game);
            return null;
        } else {
            // Send Error Message

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "player not found"
            );
        }

    }
}
