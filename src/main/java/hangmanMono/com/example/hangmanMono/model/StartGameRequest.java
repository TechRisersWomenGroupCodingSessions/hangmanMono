package hangmanMono.com.example.hangmanMono.model;

public class StartGameRequest {
    private Long id;
    private boolean startGame;

    public StartGameRequest(Long id, boolean startGame) {
        this.id = id;
        this.startGame = startGame;
    }

    public Long getId() {
        return id;
    }

    public boolean isStartGame() {
        return startGame;
    }
}
