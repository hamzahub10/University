package tn.esprit.university.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.university.Reservation;
import tn.esprit.university.TypeChambre;
import tn.esprit.university.chambre;

import java.util.List;

public interface ChambreRepository extends JpaRepository<chambre,Long> {
    /*@Query("select c from chambre c ")
    List<Object[]> nbPlacesDisponiblesParChambreAnneeEnCours();*/

    @Query("SELECT c.typeC, COUNT(c)/100 FROM chambre c GROUP BY c.typeC")
    List<Object[]> pourcentageChambresParTypeChambre();


@Query("SELECT c from  chambre c  join fetch c.blocs b order by b.nomBloc")
List<chambre> getAllChambresGroupedByBloc();
    @Query("select c from chambre c join Reservation r on r member of c.reservations where r.id not like cast(year (current_date )as string ) ")
List<chambre> getChambresNonReservees();
    @Query("SELECT c FROM chambre c WHERE c.blocs.id = :blocId AND c.typeC = 'Double'")
    List<chambre> findByTypeCDoubleAndBlocsId(@Param("blocId") long blocId);
    @Query("SELECT c FROM chambre c JOIN c.reservations r WHERE r.estValide = :estValide ")
    List<chambre> findByReservationsEstValide(@Param("estValide") boolean estValide);


    @Query("SELECT c FROM chambre c " +
            "JOIN c.blocs b " +
            "JOIN b.foyers f " +
            "JOIN f.university u " +
            "JOIN c.reservations r " +
            "WHERE u.nomUniversite = :nomUniversite " +
            "AND c.typeC = :type " +
            "AND  r.estValide = true")
    List<chambre> findChambresNonReservees(
            @Param("nomUniversite") String nomUniversite,@Param("type") TypeChambre type);

    @Query("SELECT c FROM chambre c WHERE c.blocs.id = :blocId AND c.blocs.capaciteBloc > :capacite")
    List<chambre> findByBlocsIdAndBlocsCapaciteBloc (@Param("blocId") long blocId, @Param("capacite") long capacite);

    chambre findByReservations(Reservation reservation);

    List<chambre> findByNumeroChambreIn(List<Long> numeroChambres);
    List<chambre> findByBlocs_NomBloc ( String nomBloc );
    long countByTypeCAndBlocs_Id(TypeChambre typeChambre, long idBloc);






}
