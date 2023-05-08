package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.Actors;
import ApiProyectoM12.modelo.Movies;
import ApiProyectoM12.repositorio.MoviesRepository;
import ApiProyectoM12.repositorio.ActorsRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MoviesService {
    @Autowired
    private MoviesRepository moviesRepository;

    private ActorsRepository actorsRepository;
    public List<Movies> listMovies(){return moviesRepository.findAll();}
    public void saveMovie(Movies movies){moviesRepository.save(movies);}
    public Movies findMovieById(Integer id){return moviesRepository.findById(id).get();}
    public void deleteMovie(Integer id){moviesRepository.deleteById(id);}
    public List<Movies> findTopByOrderByScoreDesc(){return moviesRepository.findTopByOrderByScoreDesc();}
    public List<Movies> findTopByOrderByScoreAsc(){return moviesRepository.findTopByOrderByScoreAsc();}
   // public List<Movies> findMoviesByReleaseDate(Date releaseDate){return moviesRepository.findMoviesByReleaseDate(releaseDate);}
    public Movies findMoviesByMovieName(String movieName){return moviesRepository.findMoviesByMovieName(movieName);}
    public Movies findMoviesAllDataById(Integer id){return moviesRepository.findMoviesAllDataById(id);}

    public void addRoleToUser(Integer id_movie, Integer id_actor) {
        Optional<Movies> optionalMovies = moviesRepository.findById(id_movie);
        Optional<Actors> optionalActors = actorsRepository.findById(id_actor);
        if (optionalMovies.isPresent() && optionalActors.isPresent()) {
            Movies movie = optionalMovies.get();
            Actors actor = optionalActors.get();
            movie.getActors().add(actor);
            moviesRepository.save(movie);
        }
    }

}
