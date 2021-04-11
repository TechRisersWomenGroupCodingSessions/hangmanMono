package hangmanMono.com.example.hangmanMono;

import hangmanMono.com.example.hangmanMono.api.PlayerController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HangmanApplicationLauncher {
	public static void main(String[] args) {
		SpringApplication.run(PlayerController.class, args);
	}
}
