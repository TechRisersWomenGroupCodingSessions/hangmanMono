package hangmanMono.com.example.hangmanMono.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void testIfSecretWordIsAllCaps() {
        String word = secretWordService.getSecretWord();
        Integer counter = 0;

        for (char letter : word.toCharArray()){
            if (Character.isUpperCase(letter)){
                counter ++;
            }
        }
        assertEquals(word.length(), counter);
    }
}
