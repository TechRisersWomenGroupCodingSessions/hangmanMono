package hangmanMono.com.example.hangmanMono.model;

import java.util.List;

public class ResponseToGuess {
    private int numberOfIncorrectGuesses;
    private boolean gameInProgress;
    private List<Letter> incorrectLetters;
    private List<Letter> correctLetters;

    public ResponseToGuess(int numberOfIncorrectGuesses, boolean gameInProgress, List<Letter> incorrectLetters, List<Letter> correctLetters) {
        this.numberOfIncorrectGuesses = numberOfIncorrectGuesses;
        this.gameInProgress = gameInProgress;
        this.incorrectLetters = incorrectLetters;
        this.correctLetters = correctLetters;
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

    public List<Letter> getCorrectLetters() {
        return correctLetters;
    }

    public void setCorrectLetters(List<Letter> correctLetters) {
        this.correctLetters = correctLetters;
    }
}
