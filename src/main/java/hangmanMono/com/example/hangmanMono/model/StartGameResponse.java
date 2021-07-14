package hangmanMono.com.example.hangmanMono.model;

import java.util.UUID;

public class StartGameResponse {

    private final Integer secretWordLength;
    private final UUID gameId;

    public StartGameResponse(Integer secretWordLength, UUID gameId) {
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
