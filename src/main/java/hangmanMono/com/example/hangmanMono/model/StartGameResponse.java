package hangmanMono.com.example.hangmanMono.model;

import java.util.UUID;

public class StartGameResponse {

    private final Integer secretWordLength;
    private final Long gameId;

    public StartGameResponse(Integer secretWordLength, Long gameId) {
        this.secretWordLength = secretWordLength;
        this.gameId = gameId;
    }
    
    public Long getGameId() {
        return gameId;
    }

    public Integer getSecretWordLength(){
        return secretWordLength;
    }
}
