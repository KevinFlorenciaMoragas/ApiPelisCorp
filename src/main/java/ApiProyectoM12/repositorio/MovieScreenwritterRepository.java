package ApiProyectoM12.repositorio;

import ApiProyectoM12.modelo.MovieScreenwritter;
import ApiProyectoM12.modelo.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieScreenwritterRepository extends JpaRepository<MovieScreenwritter,Integer> {

    List<MovieScreenwritter> findScreenwritterById (Integer ScreenwritterId);

    @Query("SELECT m, md FROM MovieScreenwritter md JOIN md.movies m WHERE md.screenwritter.id = :screenwritterId ORDER BY m.score ASC")
    List<Movies> findMoviesByScreenwritterIdOrderByScoreAsc(@Param("screenwritterId") Integer screenwritterId);

    @Query("SELECT m, md FROM MovieScreenwritter md JOIN md.movies m WHERE md.screenwritter.id = :screenwritterId ORDER BY m.score DESC")
    List<Movies> findMoviesByScreenwritterIdOrderByScoreDesc(@Param("screenwritterId") Integer screenwritterId);
}
