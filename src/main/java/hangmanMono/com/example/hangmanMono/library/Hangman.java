package hangmanMono.com.example.hangmanMono.library;

import hangmanMono.com.example.hangmanMono.model.GuessResult;
import hangmanMono.com.example.hangmanMono.model.Letter;

import java.util.*;

public class Hangman {
    private final String secretWord;
    private boolean isInProgress;
    private TreeMap<String, String> guesses;
    private int lives;
    private boolean gameIsWon;
    private ArrayList<Letter> correctGuesses;
    private ArrayList<Letter> incorrectGuesses;

    public Hangman(String secretWord) {

        this.secretWord = secretWord.toUpperCase();
        this.isInProgress = true;
        this.guesses = new TreeMap<>();
        this.lives = 10;
        this.gameIsWon = false;
        this.correctGuesses = new ArrayList<>();
        this.incorrectGuesses = new ArrayList<>();
    }

    public String getSecretWord() {
        return secretWord;
    }

    public boolean isGameInProgress() {
        return isInProgress;
    }

    public GuessResult guess(String letter) {
        //need to handle this boundary when no lives is left
        if (this.lives == 0) {

        }

        String upperCaseLetter = letter.toUpperCase();

        if (isDuplicateGuess(upperCaseLetter)) {
            this.lives--;
            return GuessResult.DUPLICATE;
        }

        if (letter.matches("[a-zA-Z]") && checkInWord(upperCaseLetter)) {
            ArrayList<Integer> positions = calculatePositions(upperCaseLetter);
            correctGuesses.add(new Letter(upperCaseLetter, positions));
            return GuessResult.CORRECT;
        } else {
            ArrayList<Integer> positions = calculatePositions(upperCaseLetter);
            incorrectGuesses.add(new Letter(upperCaseLetter, positions));
            this.lives--;
        }

        if (!isGameWon() && lives == 0) {
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
        return correctGuesses.size() == distinct.size();
    }

    public int getLives() {
        return this.lives;
    }

    public int getNumberOfIncorrectGuesses() {
        return this.incorrectGuesses.size();
    }

    public ArrayList<Integer> calculatePositions(String letter) {
        ArrayList<Integer> positions = new ArrayList<>();
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == letter.charAt(0)) {
                positions.add(i);
            }
        }
        return positions;
    }

    public ArrayList<Letter> getCorrectGuesses() {
        return correctGuesses;
    }

    public ArrayList<Letter> getIncorrectGuesses() {
        return incorrectGuesses;
    }

    public boolean isDuplicateGuess(String letter) {
        Optional<Letter> correctDuplicate = correctGuesses.stream().parallel().filter(correctGuess -> correctGuess.getLetter().equals(letter)).findFirst();
        Optional<Letter> incorrectDuplicate = incorrectGuesses.stream().parallel().filter(incorrectGuess -> incorrectGuess.getLetter().equals(letter)).findFirst();

        if (correctDuplicate.isPresent() || incorrectDuplicate.isPresent()) {
            return true;
        }
        return false;
    }
}
