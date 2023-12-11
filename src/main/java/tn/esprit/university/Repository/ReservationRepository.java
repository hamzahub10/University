package tn.esprit.university.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.university.Reservation;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    @Query("SELECT r FROM chambre c " +
            "JOIN c.reservations r " +
            "JOIN c.blocs b " +
            "JOIN b.foyers f " +
            "JOIN f.university u " +
            "WHERE r.anneuniversitaire = :anneeUniversitaire " +
            "AND u.nomUniversite = :nomUniversite")
    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(
            @Param("anneeUniversitaire") Date anneeUniversitaire,
            @Param("nomUniversite") String nomUniversite);



    @Query("SELECT r FROM Reservation r WHERE EXTRACT(YEAR FROM r.anneuniversitaire) = :year")
    List<Reservation> getReservationByYear(@Param("year") int year);

    Reservation findById(String id);
    @Query("SELECT r FROM Reservation r JOIN r.etudiants e WHERE e.cin = :cin ")
   Reservation findByEtudiant_Cin(@Param("cin") long cin);


}
