package ApiProyectoM12.repositorio;

import ApiProyectoM12.modelo.Movies;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Date;
import java.util.List;

public interface MoviesRepository extends JpaRepository<Movies,Integer> {

    List<Movies> findByOrderByScoreDesc();
    List<Movies> findByOrderByScoreAsc();
   /* @Query("select m from Movies m Where m.releaseDate = ?1")

    List<Movies> findMoviesByReleaseDate(Date releaseDate);*/
    @Query("select m.duration, m.movieName from Movies m Where m.movieName = ?1")
    Movies findMoviesByMovieName(String movieName);
    @Query ("SELECT m.*, d.*,screen.*,g.*,a.* FROM Movies m INNER JOIN movie_director r_md ON m.id = r_md.id_movie INNER JOIN director d ON d.id = r_md.id_movie INNER JOIN movie_actor r_ma ON m.id = r_ma.id_movie INNER JOIN actors a ON r_ma.id_actor = a.id INNER JOIN movie_screenwritter r_ms ON r_ms.id_movie = m.id INNER JOIN screenwriter screen ON screen.id = r_ms.id_screenwritter INNER JOIN movie_genre r_mg ON r_mg.id_movie = m.id INNER JOIN genre g ON g.id = r_mg.id_genre WHERE m.id = ?1")
    Movies findMoviesAllDataById(Integer id);
    @Query("select m from Movies m INNER JOIN Genre g ON g.id = m.id WHERE g.genre = ?1")
    List<Movies>findMoviesByGenre(String genre);

}

