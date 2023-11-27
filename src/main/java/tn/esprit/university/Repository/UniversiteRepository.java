package tn.esprit.university.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.university.universite;

public interface UniversiteRepository extends JpaRepository<universite,Long> {
    universite findByNomUniversite(String nomUniversite);

}
