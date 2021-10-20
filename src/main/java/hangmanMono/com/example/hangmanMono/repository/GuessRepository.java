package hangmanMono.com.example.hangmanMono.repository;

import hangmanMono.com.example.hangmanMono.dao.GuessDao;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GuessRepository extends JpaRepository<GuessDao, Long> {

    @Query(value = "SELECT * FROM guess WHERE game_id=?1", nativeQuery=true)
    List<GuessDao> findAllByGameId(Long gameId);
}
