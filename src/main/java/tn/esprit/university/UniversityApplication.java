package tn.esprit.university;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class UniversityApplication {

    public static void main(String[] args) {
        SpringApplication.run(UniversityApplication.class, args);
    }

}
