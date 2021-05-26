package hangmanMono.com.example.hangmanMono.model;

import java.util.UUID;

public class Hangman {
    private final String secretWord;



    private UUID gameId;

    public Hangman(String secretWord, UUID gameId){
        this.secretWord = secretWord;
        this.gameId = gameId;
    }

    public Hangman(String secretWord, boolean isInProgress, int correctGuesses, int numberOfGuesses) {
        this.secretWord = secretWord;

    }
    public String getSecretWord() {
        return secretWord;
    }

}
