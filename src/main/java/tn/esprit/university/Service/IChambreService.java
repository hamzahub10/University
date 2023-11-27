package tn.esprit.university.Service;



import tn.esprit.university.TypeChambre;
import tn.esprit.university.bloc;
import tn.esprit.university.chambre;

import java.util.List;

public interface IChambreService {
    List<chambre> addChambres (List<chambre> blocs);
    public List<chambre> getChambresParNomBloc ( String nomBloc );
    public long nbrChambreParTypeEtBloc(TypeChambre typeChambre, long idBloc );
    public List<chambre> getChambresNonReserveParNomUniversiteEtTypeChambre( String nomUniversite,TypeChambre type) ;


}
