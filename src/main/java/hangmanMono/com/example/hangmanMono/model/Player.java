package hangmanMono.com.example.hangmanMono.model;

import javax.persistence.*;

@Entity(name = "PLAYER")
@Table
public class Player {
    @Id
    @SequenceGenerator(
            name = "player_sequence",
            sequenceName = "player_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "player_sequence"
    )

    @Column(name = "ID")
    private Long id;
    private String name;

    public Player(){ }

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
