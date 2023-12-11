package tn.esprit.university;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString


public class bloc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomBloc;
    private long capaciteBloc;
    @ManyToOne
    Foyer foyers;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "blocs")
    @JsonIgnore
    private List<chambre> chambres;
}
