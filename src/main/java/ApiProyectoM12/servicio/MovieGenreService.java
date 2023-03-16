package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.MovieGenre;
import ApiProyectoM12.repositorio.MovieGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieGenreService {
    @Autowired
    private MovieGenreRepository movieGenreRepository;
    public List<MovieGenre> listMovieGenre(){return movieGenreRepository.findAll();}
    public void saveMovieGenre(MovieGenre movieGenre){movieGenreRepository.save(movieGenre);}
    public MovieGenre findMovieGenreById(Integer id){return movieGenreRepository.findById(id).get();}
    public void deleteMovieGenre(Integer id){movieGenreRepository.deleteById(id);}
}
