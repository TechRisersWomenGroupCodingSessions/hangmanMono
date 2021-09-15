package hangmanMono.com.example.hangmanMono.repository;

import hangmanMono.com.example.hangmanMono.model.Guess;
import hangmanMono.com.example.hangmanMono.model.ResponseToGuess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuessRepository extends JpaRepository<Guess, Long> {

    @Query(value = "SELECT * FROM guess WHERE game_id=?1", nativeQuery=true)
    List<Guess> findAllByGameId(Long gameId);

}
