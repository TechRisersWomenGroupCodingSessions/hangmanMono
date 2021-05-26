package hangmanMono.com.example.hangmanMono.services;

import hangmanMono.com.example.hangmanMono.model.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameService {

    private final int numberOfGuesses;
    private int incorrectGuesses;
    private boolean isInProgress;
    private List<Letter> incorrectLetters;
    private List<Letter> correctLetters;

    public GameService() {
        this.incorrectLetters = new ArrayList<>();
        this.correctLetters = new ArrayList<>();
        this.numberOfGuesses = 20;
        this.incorrectGuesses = 0;

        //need to revisit this
        this.isInProgress = false;
    }

    public int getIncorrectGuesses() {
        return incorrectGuesses;
    }
    public int getNumberOfGuesses() {
        return this.numberOfGuesses;
    }
    public Integer decrementNumberOfGuesses() {
        return this.numberOfGuesses-1;
    }
    public Integer incrementIncorrectGuesses() {
        return this.incorrectGuesses+1;
    }
    public void setInProgress(boolean inProgress) {
        isInProgress = inProgress;
    }
    public boolean isGameInProgress() {
        return isInProgress;
    }

    public ResponseToGuess guess(Guess guess) {
        decrementNumberOfGuesses();

        String upperCaseLetter = guess.getLetter().toUpperCase();
        Boolean isValidLetter = checkIfLetterIsValid(guess, upperCaseLetter);

        if (isValidLetter) {
            // TODO is this variable needed for testing?
            Boolean containsDuplicates = checkForDuplicates(guess, upperCaseLetter);
        }

        ResponseToGuess responseToGuess = new ResponseToGuess(getIncorrectGuesses(),
                isGameInProgress(), incorrectLetters, correctLetters);

        return responseToGuess;
    }

//    public void isGameInProgress() {
//        if (!isGameWon() && getNumberOfGuesses() == 0) {
//            hangman.setInProgress(false);
//        }
//    }

    public boolean getGameInProgressStatus() {
        return isGameInProgress();
    }


    public Boolean checkForDuplicates(Guess guess, String upperCaseLetter){

        if (correctLetters.contains(upperCaseLetter) || incorrectLetters.contains(upperCaseLetter)) {
            incrementIncorrectGuesses();
            return true;
        }
        return false;
    }

    public Boolean checkIfLetterIsValid(Guess guess, String upperCaseLetter) {

        // TODO is this the best place to ensure Letter is always a capital letter? Should this be checked at the database level?
        Letter letter = new Letter(upperCaseLetter);

        if (guess.getLetter().matches("[a-zA-Z]") && checkInWord(upperCaseLetter)) {
            correctLetters.add(letter);
            return true;
        } else {
            incrementIncorrectGuesses();
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
        return getNumberOfGuesses() - getIncorrectGuesses() == distinct.size();
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
