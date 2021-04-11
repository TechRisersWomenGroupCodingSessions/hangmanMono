package hangmanMono.com.example.hangmanMono.config;

import hangmanMono.com.example.hangmanMono.model.Player;
import hangmanMono.com.example.hangmanMono.repository.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PlayerConfig {

    @Bean
    CommandLineRunner commandLineRunner(PlayerRepository playerRepository){
        return args -> {
            Player jane = new Player(1L, "Jane");
            Player john = new Player(2L, "John");
            playerRepository.saveAll(List.of(jane, john));
        };
    }
}
