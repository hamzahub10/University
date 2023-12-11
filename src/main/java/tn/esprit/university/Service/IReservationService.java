package tn.esprit.university.Service;

import tn.esprit.university.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationService {
    Reservation addReservation (Reservation reservation);
    public List<Reservation> getReservationParAnneeUniversitaire(Date date );
    public Reservation ajouterReservation (long idChambre, long cinEtudiant) ;
    public Reservation annulerReservation (long cinEtudiant) ;
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite( Date anneeUniversite,
                                                                                 String nomUniversite) ;
}
