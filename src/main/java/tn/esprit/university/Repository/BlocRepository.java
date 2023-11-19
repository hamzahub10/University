package tn.esprit.university.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.university.bloc;

import java.util.List;

public interface BlocRepository extends JpaRepository<bloc, Long> {
    @Query("SELECT b FROM bloc b WHERE b.foyers.university.id = :universiteId")
    List<bloc> findByFoyersUniversityId(@Param("universiteId") long universiteId);


}
