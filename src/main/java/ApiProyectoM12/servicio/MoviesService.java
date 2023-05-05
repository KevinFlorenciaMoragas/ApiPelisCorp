package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.Movies;
import ApiProyectoM12.repositorio.MoviesRepository;
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
    public List<Movies> listMovies(){return moviesRepository.findAll();}
    public void saveMovie(Movies movies){moviesRepository.save(movies);}
    public Movies findMovieById(Integer id){return moviesRepository.findById(id).get();}
    public Movies findMovieAllDataById(Integer id){return moviesRepository.findMoviesAllDataById(id);}
    public void deleteMovie(Integer id){moviesRepository.deleteById(id);}
    public List<Movies> findTopByOrderByScoreDesc(){return moviesRepository.findTopByOrderByScoreDesc();}
    public List<Movies> findTopByOrderByScoreAsc(){return moviesRepository.findTopByOrderByScoreAsc();}
   // public List<Movies> findMoviesByReleaseDate(Date releaseDate){return moviesRepository.findMoviesByReleaseDate(releaseDate);}
    public Movies findMoviesByMovieName(String movieName){return moviesRepository.findMoviesByMovieName(movieName);}
}
