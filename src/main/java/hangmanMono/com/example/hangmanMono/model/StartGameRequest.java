package hangmanMono.com.example.hangmanMono.model;

public class StartGameRequest {
    private Long id;
    private boolean gameInProgress;

    public StartGameRequest(Long id, boolean gameInProgress) {
        this.id = id;
        this.gameInProgress = gameInProgress;
    }

    public Long getId() {
        return id;
    }

    public boolean getGameInProgress() {
        return gameInProgress;
    }
}
