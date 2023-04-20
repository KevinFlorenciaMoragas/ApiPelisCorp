package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.MovieDirector;
import ApiProyectoM12.modelo.Movies;
import ApiProyectoM12.repositorio.MovieDirectorRepository;
import ApiProyectoM12.repositorio.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieDirectorService {
    @Autowired
    private MovieDirectorRepository movieDirectorRepository;
    @Autowired
    private MoviesRepository moviesRepository;

    public List<MovieDirector> listMovieDirector(){return movieDirectorRepository.findAll();}
    public void saveMovieDirector(MovieDirector movieDirector){movieDirectorRepository.save(movieDirector);}
    public MovieDirector findMovieDirectorById(Integer id){return movieDirectorRepository.findById(id).get();}
    public void deleteMovieDirector(Integer id){movieDirectorRepository.deleteById(id);}
    public List<Movies> getmoviesbydirector(Integer directorId) {
        List<MovieDirector> movieDirectorList = movieDirectorRepository.findByDirectorId(directorId);
        List<Movies> peliculas = movieDirectorList.stream().map(MovieDirector::getMovies).collect(Collectors.toList());
        return peliculas;
    }
    public List<Movies> findMoviesByDirectorIdOrderByScoreAsc(Integer directorId) {
        return movieDirectorRepository.findMoviesByDirectorIdOrderByScoreAsc(directorId);
    }

    public List<Movies> findMoviesByDirectorIdOrderByScoreDesc(Integer directorId) {
        return movieDirectorRepository.findMoviesByDirectorIdOrderByScoreDesc(directorId);
    }

}
