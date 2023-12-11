package tn.esprit.university.Controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.university.Reservation;
import tn.esprit.university.Service.ReservationService;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/reservation")
public class reservationController {
    ReservationService reservationService;

    @PostMapping("/addReservation")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @GetMapping("/getReservationByYear")
    public List<Reservation> getReservationByYear(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return reservationService.getReservationParAnneeUniversitaire(date);

    }

    @PostMapping("/reservations/{idChambre}/{cinEtudiant}")
    public Reservation ajouterReservation(@PathVariable long idChambre, @PathVariable long cinEtudiant) {

        return reservationService.ajouterReservation(idChambre, cinEtudiant);
    }

    @PostMapping("/annulerReservation/{cinEtudiant}")
    public Reservation annulerReservation(@PathVariable long cinEtudiant) {
        return reservationService.annulerReservation(cinEtudiant);
    }

    @GetMapping("/reservations/{anneeUniversitaire}/{nomUniversite}")
    public List<Reservation> getReservations(
            @PathVariable("anneeUniversitaire") @DateTimeFormat(pattern = "yyyy-MM-dd") Date anneeUniversitaire,
            @PathVariable("nomUniversite") String nomUniversite) {

        return reservationService.getReservationParAnneeUniversitaireEtNomUniversite(anneeUniversitaire, nomUniversite);
    }
}
