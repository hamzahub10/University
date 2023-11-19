package tn.esprit.university.Service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.university.Repository.ChambreRepository;
import tn.esprit.university.TypeChambre;
import tn.esprit.university.bloc;
import tn.esprit.university.chambre;

import java.util.List;

@Service
@AllArgsConstructor


public class ChambreService implements IChambreService{

@Autowired
    ChambreRepository chambreRepository;
    @Override
    public List<chambre> addChambres(List<chambre> blocs) {
        return chambreRepository.saveAll(blocs);
    }

    @Override
    public List<chambre> getChambresParNomBloc(String nomBloc) {
        return chambreRepository.findByBlocs_NomBloc(nomBloc);
    }

    @Override
    public long nbrChambreParTypeEtBloc(TypeChambre typeChambre, long idBloc) {
        return chambreRepository.countByTypeCAndBlocs_Id(typeChambre,idBloc);
    }
}
