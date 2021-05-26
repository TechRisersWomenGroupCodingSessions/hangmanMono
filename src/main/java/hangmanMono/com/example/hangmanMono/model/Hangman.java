package hangmanMono.com.example.hangmanMono.model;

// TODO Lawrencia, can we please delete this class? =)
import java.util.UUID;

public class Hangman {
    private final String secretWord;

    public Hangman(String secretWord, UUID gameId){
        this.secretWord = secretWord;
    }

    public Hangman(String secretWord, boolean isInProgress, int correctGuesses, int numberOfGuesses) {
        this.secretWord = secretWord;

    }
    public String getSecretWord() {
        return secretWord;
    }

}
