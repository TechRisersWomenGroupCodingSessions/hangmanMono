package hangmanMono.com.example.hangmanMono.model;

public class Guess {
    private String letter;
    private Long gameId;
    private Game game;

    public Guess(String letter, Long gameId) {
        this.letter = letter;
        this.gameId = gameId;
    }

    public Guess() {
    }

    public Long getGameId() {
        return gameId;
    }


    public String getLetter() {
        return letter;
    }

    // Not needed in Model?
    public void setGame(Game game) {
        this.game = game;
    }
}
