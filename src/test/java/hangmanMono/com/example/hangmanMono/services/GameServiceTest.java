package hangmanMono.com.example.hangmanMono.services;

import hangmanMono.com.example.hangmanMono.model.*;
import hangmanMono.com.example.hangmanMono.repository.GameRepository;
import hangmanMono.com.example.hangmanMono.repository.GuessRepository;
import hangmanMono.com.example.hangmanMono.repository.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

public class GameServiceTest {

    GameService gameService;
    SecretWordService mockedSecretWordService;
    PlayerRepository mockedPlayerRepository;
    GameRepository mockedGameRepository;
    GuessRepository mockedGuessRepository;
    private Game game;
    private String secretWord;
    private Optional<Player> optionalPlayer;
    private Long playerId;
    private boolean gameInProgress;


    @BeforeEach
    public void setUp() {
        mockedGameRepository = mock(GameRepository.class);
        mockedPlayerRepository = mock(PlayerRepository.class);
        mockedSecretWordService = mock(SecretWordService.class);
        mockedGuessRepository = mock(GuessRepository.class);
        gameService = new GameService(mockedGameRepository, mockedPlayerRepository, mockedSecretWordService, mockedGuessRepository);
    }

    @Test
    public void givenStartTheGameIsCalled_whenPlayerExists_thenReturnsSecretWordLength() {
        this.setupStartGameWithPlayer();

        when(mockedSecretWordService.getSecretWord()).thenReturn(secretWord);
        when(mockedPlayerRepository.findById(any())).thenReturn(optionalPlayer);
        when(mockedGameRepository.save(any())).thenReturn(game);

        StartGameRequest request = new StartGameRequest(playerId, gameInProgress);
        StartGameResponse response = gameService.startTheGame(request);

        assertEquals(5, response.getSecretWordLength());
    }

    @Test
    public void givenStartTheGameIsCalled_whenPlayerExists_thenReturnsGameId() {
        this.setupStartGameWithPlayer();

        when(mockedSecretWordService.getSecretWord()).thenReturn(secretWord);
        when(mockedPlayerRepository.findById(any())).thenReturn(optionalPlayer);
        when(mockedGameRepository.save(any())).thenReturn(game);

        StartGameRequest request = new StartGameRequest(playerId, gameInProgress);
        StartGameResponse response = gameService.startTheGame(request);

        assertEquals(1, response.getGameId());
    }

//    @Test
//    public void givenGuessIsCalled_whenGuessIsIncorrect_thenReturnsResponse(){
//        this.setupStartGameWithPlayer();
//
//        Optional<Game> gameOptional = Optional.of(game);
//
//        when(mockedGameRepository.findById(any())).thenReturn(gameOptional);
//
//        Guess guess = new Guess("H", 1L);
//
//        Game response = gameService.guess(guess);
//        ArrayList<Letter> incorrectLetters = response.getIncorrectLetters();
//        ArrayList<Letter> correctLetters = response.getCorrectLetters();
//
//        //TODO: find away to do without mock? look closely about the mock, can be quite confusing
//
//        assertEquals(9, response.getLives());
//        assertTrue(response.isGameInProgress());
//        assertEquals(1, incorrectLetters.size());
//        assertEquals("H", incorrectLetters.get(0).getLetter());
//        assertEquals(0, correctLetters.size());
//    }

    public void setupStartGameWithPlayer(){
        playerId = 1L;
        Player player = new Player("Jack");
        optionalPlayer = Optional.of(player);
        secretWord = "APPLE";
        gameInProgress = true;
        Long gameId = 1L;
        game = new Game(secretWord, player, gameInProgress);
        game.setGameId(gameId);
    }
}

