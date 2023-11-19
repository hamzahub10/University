package tn.esprit.university.Service;

import tn.esprit.university.reservation;


import java.util.*;

public interface IReservationService {
    reservation addReservation (reservation reservation);
    List<reservation> getReservationParAnneeUniversitaire(Date date );
}
