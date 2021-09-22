package hangmanMono.com.example.hangmanMono.library;

import hangmanMono.com.example.hangmanMono.model.GuessResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {

    private Hangman hangman;

    @BeforeEach
    public void setUp() {
        hangman = new Hangman("forrest gump");
    }

    @Test
    public void testIfHangmanHasSecretWord() {
        assertFalse(hangman.getSecretWord().isEmpty());
    }

    @Test
    public void testIfSecretWordIsAllCaps() {
        hangman = new Hangman("HELLO");
        assertTrue(hangman.getSecretWord().toUpperCase().equals(hangman.getSecretWord())); }


    @Test
    public void testCheckNumberOfGuesses(){
        hangman = new Hangman("Hello");
        assertEquals(10, hangman.getLives());
    }

    @Test
    public void testCheckTheGameIsInProgress(){
        hangman = new Hangman("Hello");
        assertTrue(hangman.isGameInProgress());
    }

    @Test
    public void testGuessContainsInvalidResult() {
        GuessResult valid = hangman.guess("2");
        assertEquals(GuessResult.INCORRECT, valid);
    }

    @Test
    public void testGuessContainsValidResult() {
        hangman = new Hangman("Hello");
        GuessResult valid = hangman.guess("e");
        assertEquals(GuessResult.CORRECT, valid);
    }

    @Test
    public void testCheckIfLetterIsInWord(){
        hangman = new Hangman("Hello");
        hangman.guess("e");
        boolean isInWord = hangman.checkInWord("e");
        assertTrue(isInWord);
    }

    @Test
    public void testCheckIfLetterIsDuplicate(){
        hangman = new Hangman("Hello");
        hangman.guess("e");
        GuessResult result = hangman.guess("e");
        assertEquals(GuessResult.DUPLICATE, result);
    }

    @Test
    public void testCheckInWordNotCaseSensitive() {
        hangman = new Hangman("Hello");
        String letter = "E";
        boolean isInWord = hangman.checkInWord(letter);
        assertTrue(isInWord);
    }

    @Test
    public void testGuessDuplicateNotCaseSensitive(){
        hangman = new Hangman("Hello");
        String upperLetter = "E";
        String lowerLetter = "e";
        hangman.guess(upperLetter);
        GuessResult result = hangman.guess(lowerLetter);
        assertEquals(GuessResult.DUPLICATE, result);
    }

    @Test
    public void testGuessNotCaseSensitive(){
        hangman = new Hangman("Hello");
        String upperLetter = "E";
        GuessResult result = hangman.guess(upperLetter);
        assertEquals(GuessResult.CORRECT, result);
    }

    @Test
    public void testCheckIfGameIsNotWon() {
        hangman = new Hangman("Hello");

        assertFalse(hangman.isGameWon());
    }

    @Test
    public void testIWonIFSecretWordIsEmpty() {
        hangman = new Hangman("");
        boolean gameWon = hangman.isGameWon();
        assertTrue(gameWon);
    }

    @Test
    public void testIWonWithKale() {
        hangman = new Hangman("kale");
        hangman.guess("k");
        hangman.guess("a");
        hangman.guess("l");
        hangman.guess("e");
        boolean state = hangman.isGameWon();
        assertTrue(state);
    }

    @Test
    public void testIWonWithHello() {
        hangman = new Hangman("hello");
        hangman.guess("h");
        hangman.guess("e");
        hangman.guess("l");
        hangman.guess("o");
        boolean state = hangman.isGameWon();
        assertTrue(state);
    }

    @Test
    public void testIWonLongWord() {
        hangman = new Hangman("background");
        hangman.guess("b");
        hangman.guess("a");
        hangman.guess("c");
        hangman.guess("k");
        hangman.guess("g");
        hangman.guess("r");
        hangman.guess("o");
        hangman.guess("u");
        hangman.guess("n");
        hangman.guess("d");
        boolean gameWon = hangman.isGameWon();
        int lives = hangman.getLives();
        assertTrue(gameWon);
        assertEquals( 10, lives);
    }

    @Test
    public void testIfIncorrectGuessesIsCorrectlyCounted() {
        hangman = new Hangman("background");
        hangman.guess("l");
        hangman.guess("i");
        hangman.guess("s");
        assertEquals(3, hangman.getNumberOfIncorrectGuesses());
    }

    @Test
    public void testGameShouldHaveLost() {
        hangman = new Hangman("car");
        hangman.guess("b");
        hangman.guess("d");
        hangman.guess("e");
        hangman.guess("f");
        hangman.guess("g");
        hangman.guess("h");
        hangman.guess("i");
        hangman.guess("j");
        hangman.guess("k"); //9th guess

        assertTrue(hangman.isGameInProgress());

        //10th guess
        hangman.guess("m");

        assertFalse(hangman.isGameWon());
        assertFalse(hangman.isGameInProgress());
    }
}