package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.MovieActor;
import ApiProyectoM12.modelo.Movies;
import ApiProyectoM12.repositorio.MovieActorRepository;
import ApiProyectoM12.repositorio.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieActorService {
    @Autowired
    private MovieActorRepository movieActorRepository;

    public List<MovieActor> listMovieActor(){return movieActorRepository.findAll();}
    public void saveMovieActor(MovieActor movieActor){movieActorRepository.save(movieActor);}
    public MovieActor findMovieActorById(Integer id){return movieActorRepository.findById(id).get();}
    public void deleteMovieActor(Integer id){movieActorRepository.deleteById(id);}
    /*public List<Movies> getmoviesbyactor(Integer actorId) {
        List<MovieActor> movieActorList = movieActorRepository.findByActorId(actorId);
        List<Movies> peliculas = movieActorList.stream().map(MovieActor::getMovies).collect(Collectors.toList());
        return peliculas;
    }*/
}
