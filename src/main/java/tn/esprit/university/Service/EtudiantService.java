package tn.esprit.university.Service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.university.Repository.EtudiantRepository;
import tn.esprit.university.Etudiant;
import tn.esprit.university.Repository.ReservationRepository;
import tn.esprit.university.Reservation;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantService implements IEtudiantService{
    @Autowired
    EtudiantRepository etudiantRepository;
    ReservationRepository reservationRepository;
    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }



    @Override
    public Etudiant updateEtudiant(Etudiant etudiant,Long id) {
        if (etudiantRepository.existsById(id)) {
            etudiant.setId(id);
            return etudiantRepository.save(etudiant);
        } else {
            return null;
        }
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
        return etudiantRepository.saveAll(etudiants);
    }


    @Override
    public Etudiant retrieveEtudiant(Long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).get();
    }

    @Override
    public void removeEtudiant(Long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);

    }

    @Override
    public Etudiant affecterEtudiantAReservation(String nomEt, String prenomEt, String idReservation) {
        Etudiant etudiant=etudiantRepository.findByNomEtAndPrenomEt(nomEt,prenomEt);
        Reservation reservation=reservationRepository.findById(idReservation);

        List<Reservation> reservations=new ArrayList<>();
        if (etudiant.getReservations()!=null){
            reservations=etudiant.getReservations();
        }
        reservations.add(reservation);
        etudiant.setReservations(reservations);
        etudiantRepository.save(etudiant);

        return etudiant;
    }
    }

