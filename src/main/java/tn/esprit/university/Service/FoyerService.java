package tn.esprit.university.Service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.university.Repository.FoyerRepository;
import tn.esprit.university.Foyer;
import tn.esprit.university.Repository.UniversiteRepository;
import tn.esprit.university.universite;

import java.util.List;

@Service
@AllArgsConstructor

public class FoyerService implements IFoyerService {
    @Autowired
    FoyerRepository foyerRepository;
    UniversiteRepository universiteRepository;
    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f, Long id) {
        if (foyerRepository.existsById(id)) {
            f.setId(id);
            return foyerRepository.save(f);
        } else {
            return null;
        }
    }

    @Override
    public Foyer retrieveFoyer(long idFoyer) {
        return foyerRepository.findById(idFoyer).get();
    }

    @Override
    public void archiverFoyer(long idFoyer) {
        Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);
        if (foyer != null) {
            foyer.setArchived(true);
            foyerRepository.save(foyer);
        }
    }
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        universite universite = universiteRepository.findById(idUniversite).orElse(null);
        if (universite != null) {
            foyer.setUniversity(universite);
            Foyer addedFoyer = foyerRepository.save(foyer);
            return addedFoyer;
        }

        return null;
    }
}
