package hangmanMono.com.example.hangmanMono.model;

import java.util.UUID;

public class Guess {
    private String letter;
    private Long gameId;

    public Guess(String letter, Long gameId) {
        this.letter = letter;
        this.gameId = gameId;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }
}
