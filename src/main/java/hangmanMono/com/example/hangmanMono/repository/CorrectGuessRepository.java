package hangmanMono.com.example.hangmanMono.repository;

import hangmanMono.com.example.hangmanMono.model.CorrectGuess;
import hangmanMono.com.example.hangmanMono.model.Guess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorrectGuessRepository extends JpaRepository<CorrectGuess, Long> {

}
