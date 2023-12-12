package tn.esprit.university.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.university.Repository.ChambreRepository;
import tn.esprit.university.TypeChambre;
import tn.esprit.university.bloc;
import tn.esprit.university.chambre;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j

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

    @Override
    public List<chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type) {
        return chambreRepository.findChambresNonReservees(nomUniversite,type);
    }
    @Scheduled(cron = "*/10 * * * * *")
    public void getChambreNonReservees(){
        log.info("Liste des chambres non reservées :"+chambreRepository.getChambresNonReservees().toString());
    }
    @Scheduled(cron = "*/20 * * * * *")
    void listeChambresParBloc(){
        log.info("Liste des chambres par bloc :" +chambreRepository.getAllChambresGroupedByBloc().toString());
    }
    @Scheduled(cron = "*/30 * * * * *")
    void pourcentageChambresParTypeChambre() {
        List<Object[]> result = chambreRepository.pourcentageChambresParTypeChambre();
        log.info("Pourcentage des chambres par type : " + result);
    }


}
