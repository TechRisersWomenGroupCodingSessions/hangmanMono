package hangmanMono.com.example.hangmanMono.services;

import hangmanMono.com.example.hangmanMono.model.Player;
import hangmanMono.com.example.hangmanMono.model.ResponseToGuess;
import hangmanMono.com.example.hangmanMono.model.StartGameRequest;
import hangmanMono.com.example.hangmanMono.model.StartGameResponse;
import hangmanMono.com.example.hangmanMono.repository.GameRepository;
import hangmanMono.com.example.hangmanMono.repository.PlayerRepository;
import org.checkerframework.checker.nullness.Opt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

public class GameServiceTest {

    GameService gameService;
    SecretWordService mockedSecretWordService;
    PlayerRepository mockedPlayerRepository;
    GameRepository mockedGameRepository;
    private ResponseToGuess responseToGuess;
    private String secretWord;
    private Optional<Player> optionalPlayer;
    private Long playerId;
    private boolean gameInProgress;


    @BeforeEach
    public void setUp() {
        mockedGameRepository = mock(GameRepository.class);
        mockedPlayerRepository = mock(PlayerRepository.class);
        mockedSecretWordService = mock(SecretWordService.class);
        gameService = new GameService(mockedGameRepository, mockedPlayerRepository, mockedSecretWordService);
    }

    @Test
    public void givenStartTheGameIsCalled_whenPlayerExists_thenReturnsSecretWordLength() {
        this.setupStartGameWithPlayer();

        when(mockedSecretWordService.getSecretWord()).thenReturn(secretWord);
        when(mockedPlayerRepository.findById(any())).thenReturn(optionalPlayer);
        when(mockedGameRepository.save(any())).thenReturn(responseToGuess);

        StartGameRequest request = new StartGameRequest(playerId, gameInProgress);
        StartGameResponse response = gameService.startTheGame(request);

        assertEquals(5, response.getSecretWordLength());
    }

    @Test
    public void givenStartTheGameIsCalled_whenPlayerExists_thenReturnsGameId() {
        this.setupStartGameWithPlayer();

        when(mockedSecretWordService.getSecretWord()).thenReturn(secretWord);
        when(mockedPlayerRepository.findById(any())).thenReturn(optionalPlayer);
        when(mockedGameRepository.save(any())).thenReturn(responseToGuess);

        StartGameRequest request = new StartGameRequest(playerId, gameInProgress);
        StartGameResponse response = gameService.startTheGame(request);

        assertEquals(1, response.getGameId());
    }

    public void setupStartGameWithPlayer(){
        playerId = 1L;
        Player player = new Player("Jack");
        optionalPlayer = Optional.of(player);
        secretWord = "APPLE";
        gameInProgress = true;
        Long gameId = 1L;
        responseToGuess = new ResponseToGuess(secretWord, player, gameInProgress);
        responseToGuess.setGameId(gameId);
    }
}

