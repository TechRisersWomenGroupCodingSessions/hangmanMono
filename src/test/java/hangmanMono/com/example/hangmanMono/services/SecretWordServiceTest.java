package hangmanMono.com.example.hangmanMono.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class SecretWordServiceTest {
    private SecretWordService secretWordService;

    @BeforeEach
    public void setUp() {
        secretWordService = new SecretWordService();
    }

    @Test
    public void testIfHangmanHasSecretWord() {
        assertFalse(secretWordService.getSecretWord().isEmpty());
    }

//    @Test
//    public void testIfSecretWordIsAllCaps() {
//        assertTrue(secretWordService.getSecretWord().toUpperCase().equals(hangman.getSecretWord()));
//    }

}
