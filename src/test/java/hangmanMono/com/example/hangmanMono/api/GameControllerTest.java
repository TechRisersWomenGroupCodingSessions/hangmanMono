package hangmanMono.com.example.hangmanMono.api;

import hangmanMono.com.example.hangmanMono.model.Guess;
import hangmanMono.com.example.hangmanMono.model.ResponseToGuess;
import hangmanMono.com.example.hangmanMono.model.StartGameRequest;
import hangmanMono.com.example.hangmanMono.model.StartGameResponse;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GameControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseUrl;
    private URI uri;
    private StartGameRequest startGameRequest;

    @Test
    public void shouldHavePostEndPointToStartGame() throws URISyntaxException {
        startGameRequest = new StartGameRequest(1L, true);

        this.baseUrl = "http://localhost:" + port + "/api/v1/game/start";
        this.uri = new URI(baseUrl);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<StartGameRequest> request = new HttpEntity<>(startGameRequest, headers);
        ResponseEntity<StartGameResponse> startGameResponseResponseEntity = this.restTemplate.postForEntity(uri, request, StartGameResponse.class);

        Assert.assertEquals(200, startGameResponseResponseEntity.getStatusCodeValue());
    }

    @Test
    public void shouldHaveGuessPostEndPointOk() throws URISyntaxException {
        Guess guess = new Guess("L", 1L );

        this.baseUrl = "http://localhost:" + port + "/api/v1/game/guess";
        this.uri = new URI(baseUrl);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Guess> request = new HttpEntity<>(guess, headers);
        ResponseEntity<ResponseToGuess> responseToGuessResponseEntity = this.restTemplate.postForEntity(uri, request, ResponseToGuess.class);

        Assert.assertEquals(200, responseToGuessResponseEntity.getStatusCodeValue());
    }
}
