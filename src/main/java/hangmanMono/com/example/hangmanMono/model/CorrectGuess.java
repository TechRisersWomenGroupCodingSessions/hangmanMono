package hangmanMono.com.example.hangmanMono.model;

import javax.persistence.*;

@Entity(name = "CorrectGuess")
@Table
public class CorrectGuess {

    @Id
    @SequenceGenerator(
            name = "CorrectGuess_sequence",
            sequenceName = "CorrectGuess_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CorrectGuess_sequence"
    )

    @Column(name= "ID")
    private Long correctGuessId;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="GUESS_guessId")
    private Guess guess;

    private Long position;

    public CorrectGuess(Guess guess, Long position) {
        this.guess = guess;
        this.position = position;
    }

    public Guess getGuess() {
        return guess;
    }

    public void setGuess(Guess guess) {
        this.guess = guess;
    }

}
