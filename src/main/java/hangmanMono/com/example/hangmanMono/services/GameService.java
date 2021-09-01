package hangmanMono.com.example.hangmanMono.services;

import hangmanMono.com.example.hangmanMono.library.Hangman;
import hangmanMono.com.example.hangmanMono.model.*;
import hangmanMono.com.example.hangmanMono.repository.GameRepository;
import hangmanMono.com.example.hangmanMono.repository.GuessRepository;
import hangmanMono.com.example.hangmanMono.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final PlayerRepository playerRepository;
    private final SecretWordService secretWordService;
    private final GuessRepository guessRepository;

    @Autowired
    public GameService(GameRepository gameRepository, PlayerRepository playerRepository, SecretWordService secretWordService, GuessRepository guessRepository) {
        this.gameRepository = gameRepository;
        this.playerRepository = playerRepository;
        this.secretWordService = secretWordService;
        this.guessRepository = guessRepository;
    }

    public ResponseToGuess guess(Guess guess) {
        // TODO rename ResponseToGuess to guess?
        Optional<ResponseToGuess> gameOptional = gameRepository.findById(guess.getGameId());
        System.out.println("****" + gameOptional.get());

        if (gameOptional.isEmpty()) {
            return null;
        }

        ResponseToGuess game = gameOptional.get();
        //look up guesses by gameId > return list of guesses
        List<Guess> guessList= guessRepository.findAllByGameId(game.getGameId());


        Hangman hangman = new Hangman(game.getSecretWord());

        // loop over the list of guesses, call hangman.guess

        for(Guess item : guessList){
            String resultOfGuess = hangman.guess(item.getLetter());
            System.out.println("****" + resultOfGuess);
        }
        //save the guess to database
        guessRepository.save(guess);

        int numberOfIncorrectGuesses = hangman.getLives();
        boolean isGameInProgress = hangman.isGameInProgress();
        // Continue adding on
        game.setGameInProgress(isGameInProgress);
        game.setLives(numberOfIncorrectGuesses);
        return game;

    }

    public StartGameResponse startTheGame(StartGameRequest startGameRequest) {
        Long playerId = startGameRequest.getPlayerId();

        boolean gameInProgress = startGameRequest.getGameInProgress();

        secretWordService.randomizeSecretWord();

        String secretWord = secretWordService.getSecretWord();

        Optional<Player> player = playerRepository.findById(playerId);

        if (player.isPresent()) {
            ResponseToGuess responseToGuess = new ResponseToGuess(secretWord, player.get(), gameInProgress);

            try {
                ResponseToGuess savedGame = gameRepository.save(responseToGuess);
                System.out.println(savedGame);
                return new StartGameResponse(secretWord.length(), savedGame.getGameId());
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
