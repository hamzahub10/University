package tn.esprit.university;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class chambre implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idchambre;
    private long numeroChambre;
    //@Enumerated(EnumType.STRING)
    private TypeChambre typeC;
    @ManyToOne
    @JsonIgnore
    bloc blocs;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations;


}
