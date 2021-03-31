package springBoot.com.example.springBoot.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student Jom = new Student("Jom", "joe@gmail.com", LocalDate.of(1993, Month.JULY, 3));
            Student Dom = new Student("Dom", "joe@gmail.com", LocalDate.of(1933, Month.AUGUST, 13));

            repository.saveAll(List.of(Jom, Dom));
        };
    }
}
