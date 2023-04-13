package ApiProyectoM12.repositorio;

import ApiProyectoM12.modelo.MovieActor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieActorRepository extends JpaRepository<MovieActor,Integer> {

    /*@Query("SELECT ma FROM MovieActor ma WHERE ma.actor.id = ?1")
    List<MovieActor> findByActorId(Integer actorId);*/
}
