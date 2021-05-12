package hangmanMono.com.example.hangmanMono.model;

import java.util.UUID;

public class StartGame {

    private final Integer secretWordLength;
    private final UUID gameId;

    public StartGame(Integer secretWordLength, UUID gameId) {
        this.secretWordLength = secretWordLength;
        this.gameId = gameId;
    }
    
    public UUID getGameId() {
        return gameId;
    }

    public Integer getSecretWordLength(){
        return secretWordLength;
    }
}
