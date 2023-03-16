package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.MovieDirector;
import ApiProyectoM12.repositorio.MovieDirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieDirectorService {
    @Autowired
    private MovieDirectorRepository movieDirectorRepository;

    public List<MovieDirector> listMovieDirector(){return movieDirectorRepository.findAll();}
    public void saveMovieDirector(MovieDirector movieDirector){movieDirectorRepository.save(movieDirector);}
    public MovieDirector findMovieDirectorById(Integer id){return movieDirectorRepository.findById(id).get();}
    public void deleteMovieDirector(Integer id){movieDirectorRepository.deleteById(id);}
//    public List<MovieDirector> findByDirector(Integer id){return movieDirectorRepository.findbyDirector(id);}
}
