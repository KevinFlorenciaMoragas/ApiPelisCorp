package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.MovieActor;
import ApiProyectoM12.modelo.Movies;
import ApiProyectoM12.modelo.Actors;
import ApiProyectoM12.repositorio.MovieActorRepository;
import ApiProyectoM12.repositorio.MoviesRepository;
import ApiProyectoM12.repositorio.ActorsRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieActorService {
    @Autowired
    private MovieActorRepository movieActorRepository;

    private MoviesRepository moviesRepository;

    private ActorsRepository actorsRepository;

    public List<MovieActor> listMovieActor(){return movieActorRepository.findAll();}
    public void saveMovieActor(MovieActor movieActor){movieActorRepository.save(movieActor);}
    public MovieActor findMovieActorById(Integer id){return movieActorRepository.findById(id).get();}
    public void deleteMovieActor(Integer id){movieActorRepository.deleteById(id);}
    /*public List<Movies> getMoviesByActor(Integer actorId) {
        List<MovieActor> movieActorList = movieActorRepository.findByActorsId(actorId);
        List<Movies> movies = movieActorList.stream().map(MovieActor::getMovies).collect(Collectors.toList());
        return movies;
    }*/

    public List<Movies> findMoviesByActorIdOrderByScoreAsc(Integer directorId) {
        return movieActorRepository.findMoviesByActorIdOrderByScoreAsc(directorId);
    }

    public List<Movies> findMoviesByActorIdOrderByScoreDesc(Integer directorId) {
        return movieActorRepository.findMoviesByActorIdOrderByScoreDesc(directorId);
    }

}
