package hangmanMono.com.example.hangmanMono.services;

import hangmanMono.com.example.hangmanMono.model.Guess;
import hangmanMono.com.example.hangmanMono.model.Hangman;
import hangmanMono.com.example.hangmanMono.model.ResponseToGuess;
import hangmanMono.com.example.hangmanMono.model.StartGame;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;

@Service
public class GameService {

    private Hangman hangman;
    private TreeMap<String, String> guesses;
    private int incorrectGuesses;


    public GameService() {
        this.guesses = new TreeMap<>();
    }

    public ResponseToGuess guess(Guess guess) {
        String upperCaseLetter = letter.toUpperCase();

        //TODO continue refactoring this method
        this.hangman.setNumberOfGuesses(this.hangman.getNumberOfGuesses()-1);

        if (guesses.containsKey(upperCaseLetter)) {
            this.hangman.setNumberOfGuesses(this.hangman.getIncorrectGuesses() + 1);
            return "duplicate";
        }

        if (letter.matches("[a-zA-Z]") && checkInWord(upperCaseLetter)) {
            guesses.put(upperCaseLetter, "correct");
            return "Valid";
        } else {
            this.incorrectGuesses++;
            guesses.put(upperCaseLetter, "incorrect");
        }

        if (!isGameWon() && this.hangman.getNumberOfGuesses() == 0){
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
        return hangman.getNumberOfGuesses() - hangman.getIncorrectGuesses() == distinct.size();
    }

    public int getNumberOfIncorrectGuesses() { return this.incorrectGuesses; }

    public StartGame startTheGame() {
        SecretWordService secretWordService = new SecretWordService();
        String randomWord = secretWordService.getSecretWord();

        UUID gameId = UUID.randomUUID();
        StartGame startGame = new StartGame(randomWord.length(), gameId);

        this.hangman = new Hangman(randomWord, gameId);

        return startGame;
    }
}
