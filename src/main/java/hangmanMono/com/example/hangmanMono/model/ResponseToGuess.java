package hangmanMono.com.example.hangmanMono.model;

import java.util.ArrayList;

public class ResponseToGuess {
    private int numberOfIncorrectGuesses;
    private boolean gameInProgress;
    private List<Letter> incorrectLetters;

    public ResponseToGuess(int numberOfIncorrectGuesses) {
        this.numberOfIncorrectGuesses = numberOfIncorrectGuesses;
        this.incorrectLetters = new ArrayList<Letter>();
    }

    public int getNumberOfIncorrectGuesses() {
        return numberOfIncorrectGuesses;
    }

    public void setNumberOfIncorrectGuesses(int numberOfIncorrectGuesses) {
        this.numberOfIncorrectGuesses = numberOfIncorrectGuesses;
    }

    public boolean isGameInProgress() {
        return gameInProgress;
    }

    public void setGameInProgress(boolean gameInProgress) {
        this.gameInProgress = gameInProgress;
    }

    public List<Letter> getIncorrectLetters() {
        return incorrectLetters;
    }

    public void setIncorrectLetters(List<Letter> incorrectLetters) {
        this.incorrectLetters = incorrectLetters;
    }
}
