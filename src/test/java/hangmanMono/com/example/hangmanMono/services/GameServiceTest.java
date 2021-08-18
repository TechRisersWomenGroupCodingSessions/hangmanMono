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
    ResponseToGuess mockedResponseToGuess;

    @BeforeEach
    public void setUp() {
        mockedGameRepository = mock(GameRepository.class);
        mockedPlayerRepository = mock(PlayerRepository.class);
        mockedSecretWordService = mock(SecretWordService.class);
        mockedResponseToGuess = mock(ResponseToGuess.class);
        gameService = new GameService(mockedGameRepository, mockedPlayerRepository, mockedSecretWordService, mockedResponseToGuess);
    }

    @Test
    public void givenStartTheGameIsCalled_whenPlayerExists_thenItReturnsStartGameResponse() {
        Long playerId = 1L;
        Player player= new Player("Jack");
        Optional<Player> optionalPlayer = Optional.of(player);
        String secretWord = "APPLE";
        boolean gameInProgress = true;
        Long gameId = 1L;
        ResponseToGuess responseToGuess = new ResponseToGuess(secretWord, player, gameInProgress);

        responseToGuess.setGameId(gameId);

        when(mockedSecretWordService.getSecretWord()).thenReturn(secretWord);
        when(mockedPlayerRepository.findById(playerId)).thenReturn(optionalPlayer);
        when(mockedGameRepository.save(mockedResponseToGuess)).thenReturn(responseToGuess);

        StartGameRequest request = new StartGameRequest(playerId, gameInProgress);
        StartGameResponse response = gameService.startTheGame(request);

        assertEquals(5, response.getSecretWordLength());
    }
}

