package ApiProyectoM12.servicio;


import ApiProyectoM12.modelo.MovieAward;
import ApiProyectoM12.repositorio.MovieAwardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieAwardService {
    @Autowired
    private MovieAwardRepository movieAwardRepository;

    public List<MovieAward> listMovieAward(){return movieAwardRepository.findAll();}
    public void saveMovieAward(MovieAward movieAward){movieAwardRepository.save(movieAward);}
    public MovieAward findMovieAwardById(Integer id){return movieAwardRepository.findById(id).get();}
    public void deleteMovieAward(Integer id){movieAwardRepository.deleteById(id);}
}
