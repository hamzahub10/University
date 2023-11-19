package tn.esprit.university.Service;

import tn.esprit.university.Foyer;

import java.util.List;

public interface IFoyerService {
    List<Foyer> retrieveAllFoyers();
    Foyer addFoyer (Foyer f);
    Foyer updateFoyer (Foyer f, Long id);
    Foyer retrieveFoyer (long idFoyer);
    void archiverFoyer (long idFoyer);
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite);
}
