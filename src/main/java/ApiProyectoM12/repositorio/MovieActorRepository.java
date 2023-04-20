package ApiProyectoM12.repositorio;

import ApiProyectoM12.modelo.MovieActor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieActorRepository extends JpaRepository<MovieActor,Integer> {

    List<MovieActor> findByActorId(Integer id_actor);
}
