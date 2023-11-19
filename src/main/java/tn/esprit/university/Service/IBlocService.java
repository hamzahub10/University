package tn.esprit.university.Service;

import tn.esprit.university.bloc;

import java.util.List;

public interface IBlocService {
    bloc addBlock(bloc bloc);
    bloc affecterChambresABloc(List<Long> numChambre, long idBloc);
}
