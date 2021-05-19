package hangmanMono.com.example.hangmanMono.services;

import hangmanMono.com.example.hangmanMono.model.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameService {

    private Hangman hangman;
    private List<Letter> incorrectLetters;
    private List<Letter> correctLetters;

    public GameService() {
        this.incorrectLetters = new ArrayList<>();
        this.correctLetters = new ArrayList<>();
    }

    public ResponseToGuess guess(Guess guess) {
        this.hangman.decrementNumberOfGuesses();

        String upperCaseLetter = guess.getLetter().toUpperCase();
        Boolean isValidLetter = checkIfLetterIsValid(guess, upperCaseLetter);

        if (isValidLetter) {
            // TODO is this variable needed for testing?
            Boolean containsDuplicates = checkForDuplicates(guess, upperCaseLetter);
        }

        ResponseToGuess responseToGuess = new ResponseToGuess(hangman.getIncorrectGuesses(),
                hangman.isGameInProgress(), incorrectLetters, correctLetters);

        return responseToGuess;
    }

    public void isGameInProgress() {
        if (!isGameWon() && this.hangman.getNumberOfGuesses() == 0) {
            hangman.setInProgress(false);
        }
    }

    public Boolean checkForDuplicates(Guess guess, String upperCaseLetter){

        if (correctLetters.contains(upperCaseLetter) || incorrectLetters.contains(upperCaseLetter)) {
            this.hangman.incrementIncorrectGuesses();
            return true;
        }
        return false;
    }

    public Boolean checkIfLetterIsValid(Guess guess, String upperCaseLetter) {
        Letter letter = new Letter(upperCaseLetter);

        if (guess.getLetter().matches("[a-zA-Z]") && checkInWord(upperCaseLetter)) {
            correctLetters.add(letter);
            return true;
        } else {
            this.hangman.incrementIncorrectGuesses();
            incorrectLetters.add(letter);
        }
        return false;
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

    public StartGame startTheGame() {
        SecretWordService secretWordService = new SecretWordService();
        String randomWord = secretWordService.getSecretWord();

        UUID gameId = UUID.randomUUID();
        StartGame startGame = new StartGame(randomWord.length(), gameId);

        this.hangman = new Hangman(randomWord, gameId);

        return startGame;
    }
}
