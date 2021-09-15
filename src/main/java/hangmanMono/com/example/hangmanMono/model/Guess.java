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

    @Transient
    private Long gameId;

    @ManyToOne(cascade = CascadeType.ALL) //one-to-one
    @JoinColumn(name = "GAME_ID")
    private ResponseToGuess game;

    public Guess(String letter, Long gameId) {
        this.letter = letter;
        this.gameId = gameId;
    }

    public Guess() {
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public ResponseToGuess getGame() {
        return game;
    }

    public void setGame(ResponseToGuess game) {
        this.game = game;
    }
}
