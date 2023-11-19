package tn.esprit.university.Service;

import tn.esprit.university.universite;

import java.util.List;

public interface IUniversiteService {

    List<universite> retrieveAllUniversities();
    universite addUniversity (universite u);
    universite updateUniversity (universite u,Long id);
    universite affecterFoyerAUniversite (long idFoyer, String nomUniversite) ;
    universite desaffecterFoyerAUniversite (long idUniversite) ;
    universite retrieveUniversity (long idUniversity);
    void removeUniversity  (long idUniversity );
}
