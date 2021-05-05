package hangmanMono.com.example.hangmanMono.api;

import hangmanMono.com.example.hangmanMono.model.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlayerControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PlayerController playerController;

    @Test
    void checkIfPlayerWasCreated() throws Exception {
        Player player = new Player("Bob");
        assertThat(this.restTemplate
                .postForEntity("http://localhost:" + port + "/api/v1/player", player, Player.class)
                .getStatusCodeValue())
                .isEqualTo(200);
    }

    @Test
    void checkPlayerName() throws Exception {
        Player player = new Player("Bob");

        assertThat(this.restTemplate
                .postForObject("http://localhost:" + port + "/api/v1/player", player, Player.class)
                .getName()
                .equals("Bob"));
//        System.out.println("hereee " + this.restTemplate.postForObject("http://localhost:" + port + "/api/v1/player", player, Player.class).getId());
    }
}
