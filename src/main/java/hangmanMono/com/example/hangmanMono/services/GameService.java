package hangmanMono.com.example.hangmanMono.services;

import hangmanMono.com.example.hangmanMono.dao.GameDao;
import hangmanMono.com.example.hangmanMono.dao.GuessDao;
import hangmanMono.com.example.hangmanMono.model.GuessResult;
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

    public Game guess(Guess guess) {
        Optional<GameDao> gameOptional = gameRepository.findById(guess.getGameId());

        if (gameOptional.isEmpty()) {
            return null;
        }

        GameDao gameDao = gameOptional.get();

        //TODO Implement bounded context

        // refactor
        GuessDao guessDao = new GuessDao(guess.getLetter());

        guessDao.setGame(gameDao);
        // save the guess to database
        guessRepository.save(guessDao);

        List<GuessDao> guessList = guessRepository.findAllByGameId(gameDao.getGameId());

        Hangman hangman = new Hangman(game.getSecretWord());

        // loop over the list of guesses, call hangman.guess
        // refactor ??
        for (GuessDao item : guessList){
            GuessResult resultOfGuess = hangman.guess(item.getLetter());
            System.out.println("****" + resultOfGuess);
        }

        int numberOfIncorrectGuesses = hangman.getLives();
        boolean isGameInProgress = hangman.isGameInProgress();
        ArrayList<Letter> correctGuesses = hangman.getCorrectGuesses();
        ArrayList<Letter> incorrectGuesses = hangman.getIncorrectGuesses();

        System.out.println("game in progress: " + isGameInProgress);

        game.setGameInProgress(isGameInProgress);
        game.setLives(numberOfIncorrectGuesses);
        game.setCorrectLetters(correctGuesses);
        game.setIncorrectLetters(incorrectGuesses);

        return game;
    }

    public StartGameResponse startTheGame(StartGameRequest startGameRequest) {
        Long playerId = startGameRequest.getPlayerId();

        boolean gameInProgress = startGameRequest.getGameInProgress();

        secretWordService.randomizeSecretWord();

        String secretWord = secretWordService.getSecretWord();

        Optional<Player> player = playerRepository.findById(playerId);

        if (player.isPresent()) {
            GameDao gameDao = new GameDao(secretWord, player.get(), gameInProgress);

            try {
                GameDao savedGame = gameRepository.save(gameDao);
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
