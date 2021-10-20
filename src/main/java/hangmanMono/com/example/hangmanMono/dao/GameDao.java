package hangmanMono.com.example.hangmanMono.dao;

import hangmanMono.com.example.hangmanMono.model.Player;
import javax.persistence.*;

@Entity(name = "GAME")
@Table
public class GameDao {
    // TODO decide whether we need the numberOfIncorrectGuesses here because we also have it in Hangman
    @Id
    @SequenceGenerator(
            name = "game_sequence",
            sequenceName = "game_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "game_sequence"
    )
    @Column(name = "ID")
    private Long gameId;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="PLAYER_ID")
    private Player player;

    private String secretWord;
    private boolean gameInProgress;
    private int lives;

    public GameDao() {
    }

    public GameDao(String secretWord, Player player, boolean gameInProgress){
        this.secretWord = secretWord;
        this.player = player;
        this.gameInProgress = gameInProgress;
    }

    public GameDao(int lives, boolean gameInProgress) {
        this.lives = lives;
        this.gameInProgress = gameInProgress;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Long getGameId() {
        return gameId;
    }
}
