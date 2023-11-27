package tn.esprit.university.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.university.Repository.BlocRepository;
import tn.esprit.university.Repository.ChambreRepository;
import tn.esprit.university.bloc;
import tn.esprit.university.chambre;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BlocService implements IBlocService {
    BlocRepository blocRepository;
    ChambreRepository chambreRepository;

    @Override
    public bloc addBlock(bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {

        bloc bloc = blocRepository.findById(idBloc).orElse(null);

        List<chambre> chambres = chambreRepository.findByNumeroChambreIn(numChambre);
        for (chambre ch : chambres) {
            ch.setBlocs(bloc);
            assert bloc != null;
            blocRepository.save(bloc);
        }


        return bloc;
    }
}
