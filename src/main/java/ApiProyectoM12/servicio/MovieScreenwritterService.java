package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.MovieScreenwritter;
import ApiProyectoM12.repositorio.MovieScreenwritterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieScreenwritterService {
    @Autowired
    private MovieScreenwritterRepository movieScreenwritterRepository;

    public List<MovieScreenwritter> listMovieScreenwritter(){return movieScreenwritterRepository.findAll();}
    public void saveMovieScreenwritter(MovieScreenwritter movieScreenwritter){movieScreenwritterRepository.save(movieScreenwritter);}
    public MovieScreenwritter findMovieScreenwritterById(Integer id){return movieScreenwritterRepository.findById(id).get();}
    public void deleteMovieScreenwritter(Integer id){movieScreenwritterRepository.deleteById(id);}
}
