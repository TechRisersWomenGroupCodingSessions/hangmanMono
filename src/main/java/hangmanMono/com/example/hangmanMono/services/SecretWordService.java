package hangmanMono.com.example.hangmanMono.services;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class SecretWordService {

    private String secretWord;

    public SecretWordService() { }

    public String getSecretWord() {
        return secretWord;
    }

    public void randomizeSecretWord() {
        // TODO Change somewhere else the words to be in all caps?
        // TODO How can we test for it if secretWord is being randomised?
        List<String> secretWords = Arrays.asList("CHOCOLATE", "PIZZA", "BURGERS", "SALAD");
        int random = new Random().nextInt(secretWords.size());
        String secretWord = secretWords.get(random);
        this.secretWord = secretWord;
    }



}
