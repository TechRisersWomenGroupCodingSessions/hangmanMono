package hangmanMono.com.example.hangmanMono.dao;

import hangmanMono.com.example.hangmanMono.model.Game;

import javax.persistence.*;

@Entity(name = "GUESS")
@Table
public class GuessDao {
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

    @ManyToOne(cascade = CascadeType.ALL) //one-to-one
    @JoinColumn(name = "GAME_ID")
    private Game game;

    public GuessDao(String letter) {
        this.letter = letter;

    }

    public GuessDao() {
    }

    public String getLetter() {
        return letter;
    }


    public void setGame(Game game) {
        this.game = game;
    }
}
