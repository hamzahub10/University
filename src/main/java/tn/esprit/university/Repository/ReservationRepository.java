package tn.esprit.university.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.university.reservation;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<reservation,Long> {
   List< reservation> findByAnneuniversitaire(Date anu);
}
