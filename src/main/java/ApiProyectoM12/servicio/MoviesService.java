package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.Movies;
import ApiProyectoM12.repositorio.MoviesRepository;
import ApiProyectoM12.repositorio.ReviewsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MoviesService {
    @Autowired
    private MoviesRepository moviesRepository;
    @Autowired
    private ReviewsRepository reviewsRepository;
    public List<Movies> listMovies(){return moviesRepository.findAll();}
    public void saveMovie(Movies movies){moviesRepository.save(movies);}
    public Movies findMovieById(Integer id){return moviesRepository.findById(id).get();}

    public List<Movies> findMoviesByGenreId(Integer id){return moviesRepository.findMoviesByGenreId(id);}
    //public Movies findMovieAllDataById(Integer id){return moviesRepository.findMoviesAllDataById(id);}

    public void deleteMovie(Integer id){moviesRepository.deleteById(id);}
    public List<Movies> findTopByOrderByScoreDesc(){return moviesRepository.findAllByOrderByScoreDesc();}
    public List<Movies> findTopByOrderByScoreAsc(){return moviesRepository.findAllByOrderByScoreAsc();}
   // public List<Movies> findMoviesByReleaseDate(Date releaseDate){return moviesRepository.findMoviesByReleaseDate(releaseDate);}

    public List<Movies> findMoviesByMovieName(String movieName){return moviesRepository.findByMovieNameContains(movieName);}
    public Optional<Movies> findMoviesById(Integer id_movie) {
        return moviesRepository.findById(id_movie);
    }
    //public List<Movies> findMoviesByGenre(String genre){return moviesRepository.findMoviesByGenre(genre);}
    public List<Movies> findMoviesByDirector(Integer id){return moviesRepository.findMoviesByDirectorIdOrderByScoreDesc(id);}
    public List<Movies> findMoviesByActor(Integer id){return moviesRepository.findMoviesByActorsIdOrderByScoreDesc(id);}
    public List<Movies> findMoviesScreenwritter(Integer id){return moviesRepository.findMoviesByScreenwritterIdOrderByScoreDesc(id);}

}
