package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.MovieGenre;
import ApiProyectoM12.modelo.Movies;
import ApiProyectoM12.repositorio.MovieGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieGenreService {
    @Autowired
    private MovieGenreRepository movieGenreRepository;
    public List<MovieGenre> listMovieGenre(){return movieGenreRepository.findAll();}
    public void saveMovieGenre(MovieGenre movieGenre){movieGenreRepository.save(movieGenre);}
    public MovieGenre findMovieGenreById(Integer id){return movieGenreRepository.findById(id).get();}
    public List<Movies> getMoviesbyGenre(Long generoId) {
        List<MovieGenre> movieGenreList = movieGenreRepository.findByGenreId(generoId);
        List<Movies> peliculas = movieGenreList.stream().map(MovieGenre::getMovies).collect(Collectors.toList());
        return peliculas;
    }
    public void deleteMovieGenre(Integer id){movieGenreRepository.deleteById(id);}
}
