package tn.esprit.university.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.university.TypeChambre;
import tn.esprit.university.chambre;

import java.util.List;

public interface ChambreRepository extends JpaRepository<chambre,Long> {
    @Query("SELECT c FROM chambre c WHERE c.blocs.id = :blocId AND c.typeC = 'Double'")
    List<chambre> findByTypeCDoubleAndBlocsId(@Param("blocId") long blocId);
    @Query("SELECT c FROM chambre c JOIN c.reservations r WHERE r.estValide = :estValide")
    List<chambre> findByReservationsEstValide(@Param("estValide") boolean estValide);
    @Query("SELECT c FROM chambre c WHERE c.blocs.id = :blocId AND c.blocs.capaciteBloc > :capacite")
    List<chambre> findByBlocsIdAndBlocsCapaciteBloc (@Param("blocId") long blocId, @Param("capacite") long capacite);

    List<chambre> findByNumeroChambreIn(List<Long> numeroChambres);
    List<chambre> findByBlocs_NomBloc ( String nomBloc );
    long countByTypeCAndBlocs_Id(TypeChambre typeChambre, long idBloc);





}
