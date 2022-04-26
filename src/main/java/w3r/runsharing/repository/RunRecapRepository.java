package w3r.runsharing.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import w3r.runsharing.entity.RunRecap;

import java.util.Optional;

@Repository
public interface RunRecapRepository extends JpaRepository<RunRecap, Long> {

    Page<RunRecap> findByCharacterChosen(String characterChosen, Pageable pageable);

    @Query("SELECT r FROM RunRecap r " +
            "WHERE (:host IS NULL OR r.host=:host) " +
            "AND (:characterChosen IS NULL OR r.characterChosen=:characterChosen)")
    Page<RunRecap> findByHostAndCharacterChosen(String host, String characterChosen, Pageable pageable);

    @Query("SELECT r FROM RunRecap r WHERE r.id=:id")
    Optional<RunRecap> findById(Long id);
}
