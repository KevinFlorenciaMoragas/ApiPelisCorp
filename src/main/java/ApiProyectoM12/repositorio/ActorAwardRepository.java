package ApiProyectoM12.repositorio;

import ApiProyectoM12.modelo.ActorAward;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorAwardRepository extends JpaRepository<ActorAward,Integer> {

    List<ActorAward> findByActorsId(Integer id);
}
