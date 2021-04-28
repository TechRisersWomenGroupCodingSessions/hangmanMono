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
    private TreeMap<String, String> guesses;
    private int incorrectGuesses;

    @Autowired
    public GameService(Hangman hangman) {
        this.guesses = new TreeMap<>();
        this.hangman = hangman;

    }


    public String guess(String letter) {
        String upperCaseLetter = letter.toUpperCase();

        this.hangman.setNumberOfGuesses(this.hangman.getNumberOfGuesses()-1);
        if (guesses.containsKey(upperCaseLetter)) {
            this.incorrectGuesses++;
            return "duplicate";
        }

        if (letter.matches("[a-zA-Z]") && checkInWord(upperCaseLetter)) {
            guesses.put(upperCaseLetter, "correct");
            return "Valid";
        } else {
            this.incorrectGuesses++;
            guesses.put(upperCaseLetter, "incorrect");
        }

        if(!isGameWon() && this.hangman.getNumberOfGuesses() == 0){
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
}
