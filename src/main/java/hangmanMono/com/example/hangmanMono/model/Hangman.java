package hangmanMono.com.example.hangmanMono.model;

import java.util.UUID;

public class Hangman {
    private final String secretWord;
    private boolean isInProgress;
    private int numberOfGuesses;
    private int incorrectGuesses;
    private UUID gameId;

    public Hangman(String secretWord, UUID gameId){
        this.secretWord = secretWord;
        this.gameId = gameId;
    }

    public Hangman(String secretWord, boolean isInProgress, int correctGuesses, int numberOfGuesses) {
        this.secretWord = secretWord;
        this.isInProgress = isInProgress;
        this.numberOfGuesses = numberOfGuesses;
        this.incorrectGuesses = 0;
    }

    public int getIncorrectGuesses() {
        return incorrectGuesses;
    }

    public void setInProgress(boolean inProgress) {
        isInProgress = inProgress;
    }


    public String getSecretWord() {
        return secretWord;
    }

    public void setNumberOfGuesses(int numberOfGuesses) {
        this.numberOfGuesses = numberOfGuesses;
    }
    public boolean isGameInProgress() {
        return isInProgress;
    }
    public int getNumberOfGuesses() {
        return this.numberOfGuesses;
    }

    public Integer decrementNumberOfGuesses() {
        return this.numberOfGuesses-1;
    }

    public Integer incrementIncorrectGuesses() {
        return this.incorrectGuesses+1;
    }
}
