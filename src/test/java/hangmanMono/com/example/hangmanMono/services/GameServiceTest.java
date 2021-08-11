package hangmanMono.com.example.hangmanMono.services;

import hangmanMono.com.example.hangmanMono.model.StartGameRequest;
import hangmanMono.com.example.hangmanMono.model.StartGameResponse;
import hangmanMono.com.example.hangmanMono.repository.GameRepository;
import hangmanMono.com.example.hangmanMono.repository.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

public class GameServiceTest {

    GameService gameService;
    SecretWordService mockedSecretWordService;
    PlayerRepository mockedPlayerRepository;

    @BeforeEach
    public void setUp() {
        GameRepository mockedGameRepository = mock(GameRepository.class);
        mockedPlayerRepository = mock(PlayerRepository.class);
        mockedSecretWordService = mock(SecretWordService.class);
        gameService = new GameService(mockedGameRepository, mockedPlayerRepository, mockedSecretWordService);
    }

    @Test
    public void givenStartTheGameIsCalled_whenPlayerExists_thenItReturnsStartGameResponse() {
        Long playerId = 1L;

        when(mockedSecretWordService.getSecretWord()).thenReturn("APPLE");
        when(mockedPlayerRepository.findById(playerId));
        // TODO: return player optional

        StartGameRequest request = new StartGameRequest(playerId, true);
        StartGameResponse response = gameService.startTheGame(request);

        assertEquals(5, response.getSecretWordLength());
    }
}

