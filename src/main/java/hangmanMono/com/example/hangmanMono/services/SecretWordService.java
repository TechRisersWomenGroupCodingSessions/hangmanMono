package hangmanMono.com.example.hangmanMono.services;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SecretWordService {

    private String secretWord;

    public SecretWordService() {
        this.secretWord = randomizeSecretWord();
    }

    public String getSecretWord() {
        return secretWord;
    }

    private String randomizeSecretWord() {
        // TODO Change somewhere else the words to be in all caps?
        List<String> secretWords = Arrays.asList("CHOCOLATE", "PIZZA", "BURGERS", "SALAD");
        int random = new Random().nextInt(secretWords.size());
        String secretWord = secretWords.get(random);
        return secretWord;
    }


}
