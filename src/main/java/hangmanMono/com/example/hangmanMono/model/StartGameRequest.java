package hangmanMono.com.example.hangmanMono.model;

public class StartGameRequest {
    private Long playerId;
    private boolean gameInProgress;

    public StartGameRequest(Long playerId, boolean gameInProgress) {
        this.playerId = playerId;
        this.gameInProgress = gameInProgress;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public boolean getGameInProgress() {
        return gameInProgress;
    }
}
