package tn.esprit.university.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.university.reservation;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<reservation,Long> {

    @Query("SELECT r FROM chambre c " +
            "JOIN c.reservations r " +
            "JOIN c.blocs b " +
            "JOIN b.foyers f " +
            "JOIN f.university u " +
            "WHERE r.anneuniversitaire = :anneeUniversitaire " +
            "AND u.nomUniversite = :nomUniversite")
    List<reservation> getReservationParAnneeUniversitaireEtNomUniversite(
            @Param("anneeUniversitaire") Date anneeUniversitaire,
            @Param("nomUniversite") String nomUniversite);



    @Query("SELECT r FROM reservation r WHERE EXTRACT(YEAR FROM r.anneuniversitaire) = :year")
    List<reservation> getReservationByYear(@Param("year") int year);

    reservation findByIdReservation(String idReservation);
    @Query("SELECT r FROM reservation r JOIN r.etudiants e WHERE e.cin = :cin ")
   reservation findByEtudiant_Cin(@Param("cin") long cin);


}
