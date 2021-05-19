package hangmanMono.com.example.hangmanMono.services;

import hangmanMono.com.example.hangmanMono.model.Guess;
import hangmanMono.com.example.hangmanMono.model.Hangman;
import hangmanMono.com.example.hangmanMono.model.ResponseToGuess;
import hangmanMono.com.example.hangmanMono.model.StartGame;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameService {

    private Hangman hangman;
    private List<String> incorrectLetters;
    private List<String> correctLetters;
    private int incorrectGuesses;

    public GameService() {
        this.incorrectLetters = new ArrayList<>();
        this.correctLetters = new ArrayList<>();
    }

    public ResponseToGuess guess(Guess guess) {

        this.hangman.decrementNumberOfGuesses();

        String upperCaseLetter = guess.getLetter().toUpperCase();
        Boolean containsDuplicates = checkForDuplicates(guess, upperCaseLetter);
        Boolean isValidLetter = checkIfLetterIsValid(guess, upperCaseLetter);

        ResponseToGuess responseToGuess = new ResponseToGuess(hangman.getIncorrectGuesses(),
                hangman.isGameInProgress(), incorrectLetters, correctLetters);

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
        if (guess.getLetter().matches("[a-zA-Z]") && checkInWord(upperCaseLetter)) {
            correctLetters.add(upperCaseLetter);
            return true;
        } else {
            this.incorrectGuesses++;
            incorrectLetters.add(upperCaseLetter);
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
