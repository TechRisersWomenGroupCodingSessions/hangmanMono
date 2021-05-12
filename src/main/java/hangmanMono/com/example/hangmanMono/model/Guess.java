package hangmanMono.com.example.hangmanMono.model;

import java.util.UUID;

public class Guess {
    private String letter;
    private UUID gameId;

    public Guess(String letter, UUID gameId) {
        this.letter = letter;
        this.gameId = gameId;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public UUID getGameId() {
        return gameId;
    }

    public void setGameId(UUID gameId) {
        this.gameId = gameId;
    }
}
