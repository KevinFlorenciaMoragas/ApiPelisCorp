package ApiProyectoM12.repositorio;

import ApiProyectoM12.modelo.Movies;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MoviesRepository extends JpaRepository<Movies, Integer> {
    @Query("SELECT m FROM Movies m WHERE m.movieName = :movieName")
    List<Movies> findByMovieName(String movieName);
}