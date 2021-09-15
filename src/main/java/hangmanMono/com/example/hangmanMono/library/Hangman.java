package hangmanMono.com.example.hangmanMono.library;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class Hangman {
    private final String secretWord;
    private boolean isInProgress;
    private TreeMap<String, String> guesses;
    private int lives;
    private boolean gameIsWon;
    private int correctGuesses;
    private int incorrectGuesses;

    public Hangman(String secretWord) {

        this.secretWord = secretWord.toUpperCase();
        this.isInProgress = true;
        this.guesses = new TreeMap<>();
        this.lives = 10;
        this.gameIsWon = false;
        this.correctGuesses = 0;
        this.incorrectGuesses = 0;
    }

    public String getSecretWord() {
        return secretWord;
    }


    public boolean isGameInProgress() {
        return isInProgress;
    }

    public GuessResult guess(String letter) {
        String upperCaseLetter = letter.toUpperCase();

        if (guesses.containsKey(upperCaseLetter)) {
            this.incorrectGuesses++;
            this.lives--;
            return GuessResult.DUPLICATE;
        }

        if (letter.matches("[a-zA-Z]") && checkInWord(upperCaseLetter)) {
            guesses.put(upperCaseLetter, "correct");
            this.correctGuesses++;
            return GuessResult.CORRECT;
        } else {
            this.incorrectGuesses++;
            this.lives--;
            guesses.put(upperCaseLetter, "incorrect");
        }

        if(!isGameWon() && lives == 0){
            gameIsWon = false;
            isInProgress = false;
        }

        return GuessResult.INCORRECT;
    }

    public TreeMap<String, String> getGuesses() {
        return this.guesses;
    }

    public boolean checkInWord(String letter) {
        return secretWord.contains(letter.toUpperCase());
    }

    public boolean isGameWon() {
        Set<Character> distinct = new HashSet<>();
        for (char c : secretWord.toCharArray()) {
            distinct.add(c);
        }
        return correctGuesses == distinct.size();
    }

    public int getLives() {
        return this.lives;
    }
    public int getNumberOfIncorrectGuesses() { return this.incorrectGuesses; }
}
