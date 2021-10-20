package hangmanMono.com.example.hangmanMono.model;

import java.util.ArrayList;


public class Game {

    private Long gameId;
    private String secretWord;
    private boolean gameInProgress;
    private int lives;
    private ArrayList<Letter> incorrectLetters;
    private ArrayList<Letter> correctLetters;

    public Game() {
    }

    public Game(String secretWord, boolean gameInProgress){
        this.secretWord = secretWord;
        this.gameInProgress = gameInProgress;
    }

    public Game(int lives, boolean gameInProgress, ArrayList<Letter> incorrectLetters, ArrayList<Letter> correctLetters) {
        this.lives = lives;
        this.gameInProgress = gameInProgress;
        this.incorrectLetters = incorrectLetters;
        this.correctLetters = correctLetters;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public void setGameInProgress(boolean gameInProgress) {
        this.gameInProgress = gameInProgress;
    }

    public void setIncorrectLetters(ArrayList<Letter> incorrectLetters) {
        this.incorrectLetters = incorrectLetters;
    }

    public void setCorrectLetters(ArrayList<Letter> correctLetters) {
        this.correctLetters = correctLetters;
    }

    public String getSecretWord() {
        return secretWord;
    }
}
