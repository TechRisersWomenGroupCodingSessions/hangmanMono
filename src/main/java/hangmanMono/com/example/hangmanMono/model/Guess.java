package hangmanMono.com.example.hangmanMono.model;

import javax.persistence.*;

@Entity(name = "GUESS")
@Table
public class Guess {
    @Id
    @SequenceGenerator(
            name = "guess_sequence",
            sequenceName = "guess_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "guess_sequence"
    )
    private Long guessId;
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
