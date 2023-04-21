package ApiProyectoM12.repositorio;

import ApiProyectoM12.modelo.MovieDirector;
import ApiProyectoM12.modelo.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import java.util.List;

public interface MovieDirectorRepository extends JpaRepository<MovieDirector,Integer> {

    List<MovieDirector> findByDirectorId(Integer directorId);
    
    @Query("SELECT m, md FROM MovieDirector md JOIN md.movies m WHERE md.director.id = :directorId ORDER BY m.score ASC")
    List<Movies> findMoviesByDirectorIdOrderByScoreAsc(@Param("directorId") Integer directorId);

    @Query("SELECT m, md FROM MovieDirector md JOIN md.movies m WHERE md.director.id = :directorId ORDER BY m.score DESC")
    List<Movies> findMoviesByDirectorIdOrderByScoreDesc(@Param("directorId") Integer directorId);

}
