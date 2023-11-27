package tn.esprit.university.Service;

import tn.esprit.university.reservation;

import java.util.Date;
import java.util.List;

public interface IReservationService {
    reservation addReservation (reservation reservation);
    public List<reservation> getReservationParAnneeUniversitaire(Date date );
    public reservation ajouterReservation (long idChambre, long cinEtudiant) ;
    public reservation annulerReservation (long cinEtudiant) ;
    public List<reservation> getReservationParAnneeUniversitaireEtNomUniversite( Date anneeUniversite,
                                                                                 String nomUniversite) ;
}
