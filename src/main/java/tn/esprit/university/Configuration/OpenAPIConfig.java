package tn.esprit.university.Configuration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class OpenAPIConfig {
    @Bean
    public GroupedOpenApi EtudiantApi() {
        return GroupedOpenApi.builder()
                .group("Etudiant")
                .pathsToMatch("/api/etudiants/**")
                .pathsToExclude("**")
                .build();
    }

    @Bean
    public GroupedOpenApi FoyerApi() {
        return GroupedOpenApi.builder()
                .group("Foyer")
                .pathsToMatch("/api/foyer/**")
                .pathsToExclude("**")
                .build();
    }

    @Bean
    public GroupedOpenApi UniversityApi() {
        return GroupedOpenApi.builder()
                .group("Universite")
                .pathsToMatch("/api/universite/**")
                .pathsToExclude("**")
                .build();
    }

    @Bean
    public GroupedOpenApi BlocApi() {
        return GroupedOpenApi.builder()
                .group("Bloc")
                .pathsToMatch("/api/bloc/**")
                .pathsToExclude("**")
                .build();
    }

    @Bean
    public GroupedOpenApi ChambreApi() {
        return GroupedOpenApi.builder()
                .group("Chambre")
                .pathsToMatch("/api/chambre/**")
                .pathsToExclude("**")
                .build();
    }
    @Bean
    public GroupedOpenApi ReservationApi() {
        return GroupedOpenApi.builder()
                .group("Reservation")
                .pathsToMatch("/api/reservation/**")
                .pathsToExclude("**")
                .build();
    }

}
