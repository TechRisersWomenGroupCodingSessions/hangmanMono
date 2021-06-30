package hangmanMono.com.example.hangmanMono.api;

import hangmanMono.com.example.hangmanMono.model.Player;
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

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlayerControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PlayerController playerController;

    // TODO: rewrite using new method
    @Test
    void checkMultiplePlayerIDs() throws Exception {
        Player player = new Player("Bob");
        Player player2 = new Player("Steve");

        assertThat(this.restTemplate
                .postForObject("http://localhost:" + port + "/api/v1/player", player, Player.class)
                .getId()
                .equals(2));

        assertThat(this.restTemplate
                .postForObject("http://localhost:" + port + "/api/v1/player", player2, Player.class)
                .getId()
                .equals(1));
    }

    @Test
    public void checkPlayerId() throws URISyntaxException
    {
        final String baseUrl = "http://localhost:" + port + "/api/v1/player";

        URI uri = new URI(baseUrl);

        Player player = new Player("Kate");

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<Player> request = new HttpEntity<>(player, headers);

        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

        System.out.println("******" + result.getBody());

        Assert.assertEquals(true, result.getBody().contains("\"id\":3"));
    }


    @Test
    void checkIfPlayerWasCreatedWithOKResponse() throws Exception {
        final String baseUrl = "http://localhost:" + port + "/api/v1/player";

        URI uri = new URI(baseUrl);

        Player player = new Player("Kate");

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<Player> request = new HttpEntity<>(player, headers);

        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

        // Verify ok response
        Assert.assertEquals(200, result.getStatusCodeValue());

    }

    @Test
    void checkPlayerName() throws Exception {
        final String baseUrl = "http://localhost:" + port + "/api/v1/player";

        URI uri = new URI(baseUrl);

        Player player = new Player("Bob");

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<Player> request = new HttpEntity<>(player, headers);

        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

        // Verify response has name Bob
        Assert.assertEquals(true, result.getBody().contains("\"name\":\"Bob\""));
    }

}
