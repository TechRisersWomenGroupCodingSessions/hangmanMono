//
//package hangmanMono.com.example.hangmanMono.services;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.TreeMap;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class GameServiceTest {
//
//    private GameService hangman;
//
//    @BeforeEach
//    public void setUp() {
//        hangman = new GameService();
//    }
//
//
//
//
//
//    @Test
//    public void testCheckNumberOfGuesses(){
//        hangman = new GameService("Hello");
//        assertEquals(10, hangman.getNumberOfGuessesLeft());
//    }
//
//    @Test
//    public void testCheckTheGameIsInProgress(){
//        hangman = new GameService("Hello");
//        assertTrue(hangman.isGameInProgress());
//    }
//
//    @Test
//    public void testGuessContainsInvalidResult() {
//        String valid = hangman.guess("2");
//        assertEquals("Invalid", valid);
//    }
//
//    @Test
//    public void testGuessContainsValidResult() {
//        hangman = new GameService("Hello");
//        String valid = hangman.guess("e");
//        assertEquals("Valid", valid);
//    }
//
//    @Test
//    public void testCheckIfGuessInIncorrectList(){
//        hangman = new GameService("Hello");
//        hangman.guess("a");
//        TreeMap<String, String> guesses = hangman.getGuesses();
//        assertEquals("incorrect", guesses.get("A"));
//    }
//
//    @Test
//    public void testCheckIfLetterIsInWord(){
//        hangman = new GameService("Hello");
//        hangman.guess("e");
//        boolean isInWord = hangman.checkInWord("e");
//        assertTrue(isInWord);
//    }
//
//    @Test
//    public void testCheckIfLetterIsDuplicate(){
//        hangman = new GameService("Hello");
//        hangman.guess("e");
//        String result = hangman.guess("e");
//        assertEquals( "duplicate", result);
//    }
//
//    @Test
//    public void testCheckInWordNotCaseSensitive() {
//        hangman = new GameService("Hello");
//        String letter = "E";
//        boolean isInWord = hangman.checkInWord(letter);
//        assertTrue(isInWord);
//    }
//
//    @Test
//    public void testGuessDuplicateNotCaseSensitive(){
//        hangman = new GameService("Hello");
//        String upperLetter = "E";
//        String lowerLetter = "e";
//        hangman.guess(upperLetter);
//        String result = hangman.guess(lowerLetter);
//        assertEquals("duplicate", result);
//    }
//
//    @Test
//    public void testGuessNotCaseSensitive(){
//        hangman = new GameService("Hello");
//        String upperLetter = "E";
//        String result = hangman.guess(upperLetter);
//        assertEquals("Valid", result);
//    }
//
//    @Test
//    public void testCheckIfGameIsNotWon() {
//        hangman = new GameService("Hello");
//
//        assertFalse(hangman.isGameWon());
//    }
//
//    @Test
//    public void testIWonIFSecretWordIsEmpty() {
//        hangman = new GameService("");
//        boolean gameWon = hangman.isGameWon();
//        assertTrue(gameWon);
//    }
//
//    @Test
//    public void testIWonWithKale() {
//        hangman = new GameService("kale");
//        hangman.guess("k");
//        hangman.guess("a");
//        hangman.guess("l");
//        hangman.guess("e");
//        boolean state = hangman.isGameWon();
//        assertTrue(state);
//    }
//
//    @Test
//    public void testIWonWithHello() {
//        hangman = new GameService("hello");
//        hangman.guess("h");
//        hangman.guess("e");
//        hangman.guess("l");
//        hangman.guess("o");
//        boolean state = hangman.isGameWon();
//        assertTrue(state);
//    }
//
//    @Test
//    public void testIWonLongWord() {
//        hangman = new GameService("background");
//        hangman.guess("b");
//        hangman.guess("a");
//        hangman.guess("c");
//        hangman.guess("k");
//        hangman.guess("g");
//        hangman.guess("r");
//        hangman.guess("o");
//        hangman.guess("u");
//        hangman.guess("n");
//        hangman.guess("d");
//        boolean gameWon = hangman.isGameWon();
//        int incorrectGuesses = hangman.getNumberOfGuessesLeft();
//        assertTrue(gameWon);
//        assertEquals( 0, incorrectGuesses);
//    }
//
//    @Test
//    public void testIfIncorrectGuessesIsCorrectlyCounted() {
//        hangman = new GameService("background");
//        hangman.guess("l");
//        hangman.guess("i");
//        hangman.guess("s");
//        assertEquals(3, hangman.getNumberOfIncorrectGuesses());
//    }
//
//    @Test
//    public void testIfIncorrectGuessesIsDuplicated() {
//        hangman = new GameService("background");
//        hangman.guess("l");
//        hangman.guess("x");
//        hangman.guess("x");
//        assertEquals(3, hangman.getNumberOfIncorrectGuesses());
//    }
//
//    @Test
//    public void testGameShouldHaveLost() {
//        hangman = new GameService("car");
//        hangman.guess("b");
//        hangman.guess("d");
//        hangman.guess("e");
//        hangman.guess("f");
//        hangman.guess("g");
//        hangman.guess("h");
//        hangman.guess("i");
//        hangman.guess("j");
//        hangman.guess("k"); //9th guess
//
//        assertTrue(hangman.isGameInProgress());
//
//        //10th guess
//        hangman.guess("m");
//
//        assertFalse(hangman.isGameWon());
//        assertFalse(hangman.isGameInProgress());
//    }
//}
//
