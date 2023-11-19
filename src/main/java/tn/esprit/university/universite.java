package tn.esprit.university;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class universite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomUniversite;
    private String adresse;
    @OneToOne(cascade = CascadeType.ALL)
    private Foyer foyer;
}