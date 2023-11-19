package tn.esprit.university.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.university.Repository.ReservationRepository;
import tn.esprit.university.reservation;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor

public class ReservationService implements IReservationService{
    ReservationRepository reservationRepository;

    @Override
    public reservation addReservation(reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<reservation> getReservationParAnneeUniversitaire(Date date) {
        return reservationRepository.findByAnneuniversitaire(date);
    }
}
