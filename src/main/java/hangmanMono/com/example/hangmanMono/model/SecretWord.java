package hangmanMono.com.example.hangmanMono.model;

import java.util.UUID;

public class SecretWord {

    private final Integer secretWordLength;
    private final UUID gameId;

    public SecretWord(Integer secretWordLength, UUID gameId) {
        this.secretWordLength = secretWordLength;
        this.gameId = gameId;
    }


}
