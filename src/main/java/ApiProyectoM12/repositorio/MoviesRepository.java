package ApiProyectoM12.repositorio;

import ApiProyectoM12.modelo.Movies;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


import java.util.Date;
import java.util.List;

public interface MoviesRepository extends JpaRepository<Movies,Integer> {
    @Query("select m from Movies m ORDER BY m.score DESC")
    List<Movies> findTopByOrderByScoreDesc();
    @Query("select m from Movies m ORDER BY m.score ASC")
    List<Movies> findTopByOrderByScoreAsc();
   /* @Query("select m from Movies m Where m.releaseDate = ?1")
    List<Movies> findMoviesByReleaseDate(Date releaseDate);*/
    @Query("select m from Movies m Where m.movieName = ?1")
    Movies findMoviesByMovieName(String movieName);

    @Query ("SELECT m.*, a.* FROM movies m JOIN movie_actor r_ma ON m.id = r_ma.id_movie INNER JOIN actors a ON r_ma.id_actor = a.id WHERE m.id = 1")
    Movies findMoviesAllDataById(Integer id);

}

