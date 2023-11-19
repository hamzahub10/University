package tn.esprit.university.Controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.university.Service.ReservationService;
import tn.esprit.university.reservation;

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
    public reservation addReservation(@RequestBody reservation reservation){
       return reservationService.addReservation(reservation);
    }
    @GetMapping("/getReservationParAnneeUniversitaire/{date}")
    public List<reservation> getReservationParAnneeUniversitaire(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date){
        return reservationService.getReservationParAnneeUniversitaire(date);
    }
}
