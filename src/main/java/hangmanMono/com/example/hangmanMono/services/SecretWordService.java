package hangmanMono.com.example.hangmanMono.services;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SecretWordService {

    private String secretWords;

    public String getSecretWords() {
        return secretWords;
    }

    public SecretWordService() {
        this.secretWords = randomizeSecretWord();
    }

    private String randomizeSecretWord() {
        List<String> secretWords = Arrays.asList("Chocolate", "Pizza", "Burgers", "Salad");
        int random = new Random().nextInt(secretWords.size());
        String secretWord = secretWords.get(random);
        return secretWord;
    }
}
