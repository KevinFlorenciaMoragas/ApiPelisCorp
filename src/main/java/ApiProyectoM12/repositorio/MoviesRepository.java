package ApiProyectoM12.repositorio;

import ApiProyectoM12.modelo.Movies;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Date;
import java.util.List;

public interface MoviesRepository extends JpaRepository<Movies,Integer> {
    @Query("select m from Movies m ORDER BY m.score DESC")
    List<Movies> findTopByOrderByScoreDesc();
    @Query("select m from Movies m ORDER BY m.score ASC")
    List<Movies> findTopByOrderByScoreAsc();
   /* @Query("select m from Movies m Where m.releaseDate = ?1")
    List<Movies> findMoviesByReleaseDate(Date releaseDate);*/
    @Query("select m.duration, m.movieName from Movies m Where m.movieName = ?1")
    Movies findMoviesByMovieName(String movieName);
    @Query ("SELECT m.*, d.*,screen.*,g.*,a.* FROM Movies m LEFT JOIN movie_director r_md ON m.id = r_md.id_movie LEFT JOIN director d ON d.id = r_md.id_movie LEFT JOIN movie_actor r_ma ON m.id = r_ma.id_movie LEFT JOIN actors a ON r_ma.id_actor = a.id LEFT JOIN movie_screenwritter r_ms ON r_ms.id_movie = m.id LEFT JOIN screenwriter screen ON screen.id = r_ms.id_screenwritter LEFT JOIN movie_genre r_mg ON r_mg.id_movie = m.id LEFT JOIN genre g ON g.id = r_mg.id_genre WHERE m.id = ?1")
    Movies findMoviesAllDataById(Integer id);

}

