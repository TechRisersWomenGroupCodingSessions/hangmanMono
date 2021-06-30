package hangmanMono.com.example.hangmanMono;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("application.properties")
@SpringBootApplication
public class HangmanApplicationLauncher {
	public static void main(String[] args) {
		SpringApplication.run(HangmanApplicationLauncher.class, args);
	}
}
