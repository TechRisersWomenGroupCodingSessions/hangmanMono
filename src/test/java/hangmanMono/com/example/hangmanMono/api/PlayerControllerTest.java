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

    @Autowired
    private PlayerController playerController;

    private URI uri;
    private Player player;
    private String baseUrl;

    @BeforeEach
    public void start() throws URISyntaxException {
        this.baseUrl = "http://localhost:" + port + "/api/v1/player";

        this.uri = new URI(baseUrl);

        this.player = new Player("Bob");
    }

    // TODO: rewrite using new method
//    @Test
//    public void checkMultiplePlayerIDs() throws Exception {
//        Player player = new Player("Bob");
//        Player player2 = new Player("Steve");
//
//        assertThat(this.restTemplate
//                .postForObject("http://localhost:" + port + "/api/v1/player", player, Player.class)
//                .getId()
//                .equals(2));
//
//        assertThat(this.restTemplate
//                .postForObject("http://localhost:" + port + "/api/v1/player", player2, Player.class)
//                .getId()
//                .equals(1));
//    }

//    @Test
//    public void checkMultiplePlayersIDs() throws URISyntaxException {
//        Player player2 = new Player("Steve");
//
//
//        HttpHeaders headers = new HttpHeaders();
//
//        HttpEntity<Player> request = new HttpEntity<>(player, headers);
//
//        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
//
//        System.out.println("******" + result.getBody());
//
//        Assert.assertEquals(true, result.getBody().contains("\"id\":3, \"name\": \"Kate\""));
////        Assert.assertEquals(true, result.getBody().contains("\"id\":4, \"name\": \"Steve\""));
//    }

    @Test
    public void checkPlayerId() throws URISyntaxException
    {

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<Player> request = new HttpEntity<>(player, headers);

        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

        System.out.println("******" + result.getBody());

        Assert.assertEquals(true, result.getBody().contains("\"id\":5"));

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

        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

        // Verify response has name Bob
        Assert.assertEquals(true, result.getBody().contains("\"name\":\"Bob\""));
    }

}
