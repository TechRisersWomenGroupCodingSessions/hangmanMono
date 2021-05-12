package hangmanMono.com.example.hangmanMono.model;

import java.util.ArrayList;
import java.util.List;

public class Letter {
    private String letter;
    private List<Integer> position = new ArrayList<>();

    public Letter(String letter) {
        this.letter = letter;
    }

    public Letter(String letter, List<Integer> position) {
        this.letter = letter;
        this.position = position;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public List<Integer> getPosition() {
        return position;
    }

    public void setPosition(List<Integer> position) {
        this.position = position;
    }
}
