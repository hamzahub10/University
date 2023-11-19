package tn.esprit.university.Service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.university.Foyer;
import tn.esprit.university.Repository.FoyerRepository;
import tn.esprit.university.Repository.UniversiteRepository;
import tn.esprit.university.universite;

import java.util.List;

@Service
@AllArgsConstructor

public class UniversiteService implements IUniversiteService{
    @Autowired
    UniversiteRepository universiteRepository;
    FoyerRepository foyerRepository;

    @Override
    public List<universite> retrieveAllUniversities() {
        return universiteRepository.findAll();
    }

    @Override
    public universite addUniversity(universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public universite updateUniversity(universite u,Long id) {
        if (universiteRepository.existsById(id)){
            u.setId(id);
            return universiteRepository.save(u);
        }else {
            return null;
        }

    }

    @Override
    public universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        universite universite= universiteRepository.findByNomUniversite(nomUniversite);
      Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);
      universite.setFoyer(foyer);
       return universiteRepository.save(universite);
    }

    @Override
    public universite desaffecterFoyerAUniversite(long idUniversite) {
        universite universite = universiteRepository.findById(idUniversite).orElse(null);
        assert universite != null;
        universite.setFoyer(null);
        return universiteRepository.save(universite);
    }

    @Override
    public universite retrieveUniversity(long idUniversity) {
        return universiteRepository.findById(idUniversity).orElse(null);
    }

    @Override
    public void removeUniversity(long idUniversity) {
        universiteRepository.deleteById(idUniversity);
    }
}
