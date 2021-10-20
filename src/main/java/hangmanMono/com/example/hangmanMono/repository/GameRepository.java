package hangmanMono.com.example.hangmanMono.repository;

import hangmanMono.com.example.hangmanMono.dao.GameDao;
import hangmanMono.com.example.hangmanMono.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<GameDao, Long> {
}
