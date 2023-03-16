package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.Movies;
import ApiProyectoM12.repositorio.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService {
    @Autowired
    private MoviesRepository moviesRepository;
    public List<Movies> listMovies(){return moviesRepository.findAll();}
    public void saveMovie(Movies movies){moviesRepository.save(movies);}
    public Movies findMovieById(Integer id){return moviesRepository.findById(id).get();}
    public void deleteMovie(Integer id){moviesRepository.deleteById(id);}


}
