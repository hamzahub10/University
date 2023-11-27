package tn.esprit.university.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.university.Etudiant;
import tn.esprit.university.Repository.ChambreRepository;
import tn.esprit.university.Repository.EtudiantRepository;
import tn.esprit.university.Repository.ReservationRepository;
import tn.esprit.university.chambre;
import tn.esprit.university.reservation;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor

public class ReservationService implements IReservationService {

    ReservationRepository reservationRepository;
    ChambreRepository chambreRepository;
    EtudiantRepository etudiantRepository;


    @Override
    public reservation addReservation(reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<reservation> getReservationParAnneeUniversitaire(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return reservationRepository.getReservationByYear(calendar.get(Calendar.YEAR));
    }

    @Override
    public reservation ajouterReservation(long idChambre, long cinEtudiant) {
        chambre chambre = chambreRepository.findById(idChambre).orElse(null);
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);

        reservation reservation = null;

        if (chambre != null && etudiant != null) {
            int maxCapacity;
            switch (chambre.getTypeC()) {
                case Simple:
                    maxCapacity = 1;
                    break;
                case Double:
                    maxCapacity = 2;
                    break;
                case Triple:
                    maxCapacity = 3;
                    break;
                default:
                    maxCapacity = 0;
                    break;
            }

            if (chambre.getReservations().size() < maxCapacity) {
                reservation = new reservation();
                reservation.setIdReservation(chambre.getNumeroChambre() + "-" + chambre.getBlocs().getNomBloc() + "-" + 2023);
                reservation.setEstValide(true);

                chambre.getReservations().add(reservation);
                etudiant.getReservations().add(reservation);

                chambreRepository.save(chambre);
                etudiantRepository.save(etudiant);
                reservationRepository.save(reservation);

                return reservation;
            }
        }
        return null;
    }

    @Override
    public reservation annulerReservation(long cinEtudiant) {
        reservation reservation =reservationRepository.findByEtudiant_Cin(cinEtudiant);
        chambre chambre= chambreRepository.findByReservations(reservation);
        reservation.setEstValide(false);
        reservation.getEtudiants().clear();
        chambre.getReservations().remove(reservation);
        reservationRepository.save(reservation);
        chambreRepository.save(chambre);
        return reservation;
    }

    @Override
    public List<reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversite, String nomUniversite) {
        return reservationRepository.getReservationParAnneeUniversitaireEtNomUniversite(anneeUniversite,
                nomUniversite);
    }


}
