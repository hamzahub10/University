package tn.esprit.university.Service;

import tn.esprit.university.Etudiant;

import java.util.List;

public interface IEtudiantService {
    List<Etudiant> retrieveAllEtudiants();

    Etudiant addEtudiant(Etudiant e);

    Etudiant updateEtudiant(Etudiant e,Long id);
    List<Etudiant> addEtudiants (List<Etudiant> etudiants);


    Etudiant retrieveEtudiant(Long idEtudiant);

    void removeEtudiant(Long idEtudiant);
    Etudiant affecterEtudiantAReservation(String nomEt , String prenomEt , String idReservation );

}
