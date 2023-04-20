package ApiProyectoM12.repositorio;

import ApiProyectoM12.modelo.MovieActor;
import ApiProyectoM12.modelo.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieActorRepository extends JpaRepository<MovieActor,Integer> {

    List<MovieActor> findByActorsId(Integer actorId);

    @Query("SELECT m, md FROM MovieActor md JOIN md.movies m WHERE md.actors.id = :actorId ORDER BY m.score ASC")
    List<Movies> findMoviesByActorIdOrderByScoreAsc(@Param("actorId") Integer actorId);

    @Query("SELECT m, md FROM MovieActor md JOIN md.movies m WHERE md.actors.id = :actorId ORDER BY m.score DESC")
    List<Movies> findMoviesByActorIdOrderByScoreDesc(@Param("actorId") Integer actorId);
}
