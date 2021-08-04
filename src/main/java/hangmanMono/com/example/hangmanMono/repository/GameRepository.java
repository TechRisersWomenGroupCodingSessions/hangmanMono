package hangmanMono.com.example.hangmanMono.repository;

import hangmanMono.com.example.hangmanMono.model.ResponseToGuess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<ResponseToGuess, Long> {
}
