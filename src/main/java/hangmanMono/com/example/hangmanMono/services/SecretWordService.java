package hangmanMono.com.example.hangmanMono.services;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SecretWordService {

    private String secretWord;

    public SecretWordService() {
    }

    public String getSecretWord() {
        return secretWord;
    }

    public void randomizeSecretWord() {
        List<String> secretWords = Arrays.asList("CHOCOLATE", "PIZZA", "BURGERS", "SALAD");
        int random = new Random().nextInt(secretWords.size());
        this.secretWord = secretWords.get(random);
    }


}
