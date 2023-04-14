package ApiProyectoM12.servicio;


import ApiProyectoM12.modelo.MovieAward;
import ApiProyectoM12.modelo.Movies;
import ApiProyectoM12.repositorio.MovieAwardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieAwardService {
    @Autowired
    private MovieAwardRepository movieAwardRepository;

    public List<MovieAward> listMovieAward(){return movieAwardRepository.findAll();}
    public void saveMovieAward(MovieAward movieAward){movieAwardRepository.save(movieAward);}
    public MovieAward findMovieAwardById(Integer id){return movieAwardRepository.findById(id).get();}

    /*public List<Movies> getmoviesbyAwardsid(Integer awardId) {
        List<MovieAward> movieAwardList = movieAwardRepository.findByAwardId(awardId);
        List<Movies> movies = movieAwardList.stream().map(MovieAward::getMovies).collect(Collectors.toList());
        return movies;
    }*/
    public void deleteMovieAward(Integer id){movieAwardRepository.deleteById(id);}
}
