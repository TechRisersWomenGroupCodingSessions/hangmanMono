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
    private final SecretWordService secretWordService;
    private final ResponseToGuess responseToGuess;

    @Autowired
    public GameService(GameRepository gameRepository, PlayerRepository playerRepository, SecretWordService secretWordService, ResponseToGuess responseToGuess) {
        this.gameRepository = gameRepository;
        this.playerRepository = playerRepository;
        this.secretWordService = secretWordService;
        this.responseToGuess = responseToGuess;
    }

    public ResponseToGuess guess(Guess guess) {
        return null;
    }

    public StartGameResponse startTheGame(StartGameRequest startGameRequest) {
        Long playerId = startGameRequest.getPlayerId();
        boolean gameInProgress = startGameRequest.getGameInProgress();

        secretWordService.randomizeSecretWord();
        String secretWord = secretWordService.getSecretWord();

        Optional<Player> player = playerRepository.findById(playerId);

        if (player.isPresent()){
//            ResponseToGuess game = new ResponseToGuess(secretWord, player.get(), gameInProgress);
            responseToGuess.setSecretWord(secretWord);
            responseToGuess.setPlayer(player.get());
            responseToGuess.setGameInProgress(gameInProgress);

            try {
                ResponseToGuess savedGame = gameRepository.save(responseToGuess); // mock return value of save()

                Long savedGameId = savedGame.getGameId();

                return new StartGameResponse(secretWord.length(), savedGameId);

            } catch (NullPointerException e) {
                throw new ResponseStatusException(
                        HttpStatus.INTERNAL_SERVER_ERROR, "Cannot save the game"
                );
            }



        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "player not found"
            );
        }
    }
}
