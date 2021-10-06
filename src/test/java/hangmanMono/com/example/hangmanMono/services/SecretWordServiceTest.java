package hangmanMono.com.example.hangmanMono.services;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SecretWordServiceTest {
    private SecretWordService secretWordService;

    @BeforeEach
    public void setUp() {
        secretWordService = new SecretWordService();
    }

    @Test
    public void testIfHangmanHasSecretWord() {
        secretWordService.randomizeSecretWord();
        assertNotNull(secretWordService.getSecretWord());
    }

    @Test
    public void testIfSecretWordIsAllCaps() {
        secretWordService.randomizeSecretWord();
        String word = secretWordService.getSecretWord();
        Integer counter = 0;

        for (char letter : word.toCharArray()) {
            if (Character.isUpperCase(letter)) {
                counter++;
            }
        }
        assertEquals(word.length(), counter);
    }
}
