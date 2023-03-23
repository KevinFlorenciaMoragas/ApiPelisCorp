package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.Movies;
import ApiProyectoM12.repositorio.MoviesRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoviesService {
    @Autowired
    private MoviesRepository moviesRepository;
    public List<Movies> listMovies(){return moviesRepository.findAll();}
    public void saveMovie(Movies movies){moviesRepository.save(movies);}
    public Movies findMovieById(Integer id){return moviesRepository.findById(id).get();}

    public List<Movies> findMovieByName(String movieName){return moviesRepository.findByMovieName(movieName);}

    public void deleteMovie(Integer id){moviesRepository.deleteById(id);}



}
