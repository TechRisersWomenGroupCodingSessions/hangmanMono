package hangmanMono.com.example.hangmanMono.model;

public class Hangman {
    private final String secretWord;
    private boolean isInProgress;
    private int numberOfGuesses;
    private int incorrectGuesses;

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
}
