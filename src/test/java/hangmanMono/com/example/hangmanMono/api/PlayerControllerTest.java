package hangmanMono.com.example.hangmanMono.api;

import hangmanMono.com.example.hangmanMono.model.Player;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlayerControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private URI uri;
    private Player player;
    private String baseUrl;

    @BeforeEach
    public void start() throws URISyntaxException {
        this.baseUrl = "http://localhost:" + port + "/api/v1/player";

        this.uri = new URI(baseUrl);

        this.player = new Player("Bob");
    }

    @Test
    public void checkMultiplePlayersIDs() throws URISyntaxException {
        Player player2 = new Player("Steve");

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<Player> request = new HttpEntity<>(player, headers);

        ResponseEntity<Player> result= this.restTemplate.postForEntity(uri, request, Player.class);

        HttpEntity<Player> request2 = new HttpEntity<>(player2, headers);

        ResponseEntity<Player> result2 = this.restTemplate.postForEntity(uri, request2, Player.class);

        System.out.println("******" + result.getBody());

        Player body = result.getBody();

        Long firstID = body.getId();

        Long secondID = firstID + 1;

        Assert.assertNotNull(firstID);

        Assert.assertNotNull(result2.getBody().getId());

        Assert.assertEquals(secondID, result2.getBody().getId());
    }

    @Test
    public void checkPlayerId() throws URISyntaxException
    {

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<Player> request = new HttpEntity<>(player, headers);

        ResponseEntity<Player> playerResponseEntity = this.restTemplate.postForEntity(uri, request, Player.class);

        Player body = playerResponseEntity.getBody();

        Assert.assertNotNull(body.getId());

    }


    @Test
    public void checkIfPlayerWasCreatedWithOKResponse() throws Exception {

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<Player> request = new HttpEntity<>(player, headers);

        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

        // Verify ok response
        Assert.assertEquals(200, result.getStatusCodeValue());

    }

    @Test
    public void checkPlayerName() throws Exception {

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<Player> request = new HttpEntity<>(player, headers);

        ResponseEntity<Player> playerResponseEntity = this.restTemplate.postForEntity(uri, request, Player.class);

        Player body = playerResponseEntity.getBody();

        // Verify response has name Bob
        Assert.assertEquals("Bob", body.getName());
    }

}
