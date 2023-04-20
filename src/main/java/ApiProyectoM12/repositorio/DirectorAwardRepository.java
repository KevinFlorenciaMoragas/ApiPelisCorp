package ApiProyectoM12.repositorio;

import ApiProyectoM12.modelo.DirectorAward;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectorAwardRepository extends JpaRepository<DirectorAward,Integer> {

    List<DirectorAward> findByDirectorId(Long directorId);
}
