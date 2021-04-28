package hangmanMono.com.example.hangmanMono.services;

import hangmanMono.com.example.hangmanMono.model.Hangman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

@Service
public class GameService {

    private final Hangman hangman;

//    private final String secretWord;
//    private boolean isInProgress;
    private TreeMap<String, String> guesses;
//    private int guessesInTotal;
    private boolean gameIsWon;
//    private int correctGuesses;
    private int incorrectGuesses;

    @Autowired
    public GameService(String secretWord, Hangman hangman) {
//        this.secretWord = secretWord.toUpperCase();
//        this.isInProgress = true;
        this.guesses = new TreeMap<>();
//        this.guessesInTotal = 10;
        this.gameIsWon = false;
//        this.correctGuesses = 0;
        this.incorrectGuesses = 0;
        this.hangman = hangman;
    }

//    public boolean isGameInProgress() {
//        return isInProgress;
//    }

    public String guess(String letter) {
        String upperCaseLetter = letter.toUpperCase();

        this.hangman.setNumberOfGuesses(this.hangman.getNumberOfGuesses()-1);
        if (guesses.containsKey(upperCaseLetter)) {
            this.incorrectGuesses++;
            return "duplicate";
        }

        if (letter.matches("[a-zA-Z]") && checkInWord(upperCaseLetter)) {
            guesses.put(upperCaseLetter, "correct");
            this.correctGuesses++;
            return "Valid";
        } else {
            this.incorrectGuesses++;
            guesses.put(upperCaseLetter, "incorrect");
        }

        if(!isGameWon() && this.hangman.getNumberOfGuesses() == 0){
            gameIsWon = false;
            hangman.setInProgress(false);
        }

        return "Invalid";
    }

    public TreeMap<String, String> getGuesses() {
        return this.guesses;
    }

    public boolean checkInWord(String letter) {
        return hangman.getSecretWord().contains(letter.toUpperCase());
    }

    public boolean isGameWon() {
        Set<Character> distinct = new HashSet<>();
        for (char c : hangman.getSecretWord().toCharArray()) {
            distinct.add(c);
        }
        return correctGuesses == distinct.size();
    }

//    public int getNumberOfGuessesLeft() {
//        return this.guessesInTotal;
//    }
    public int getNumberOfIncorrectGuesses() { return this.incorrectGuesses; }
}
