package ApiProyectoM12.controlador;

import ApiProyectoM12.modelo.Movies;
import ApiProyectoM12.servicio.MoviesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class MoviesController {
    private final MoviesService moviesService;

    @GetMapping("/movies")
    public List<Movies> listFavorite() {
        return moviesService.listMovies();
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movies> getMovieById(@PathVariable Integer id) {
        try {
            Movies movie = moviesService.findMovieById(id);
            return ResponseEntity.ok(movie);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/movies")
    public ResponseEntity<Movies> newMovies(@RequestBody Movies movies) {
        try {
            System.out.println(movies);
            moviesService.saveMovie(movies);
            return null;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<?> editMovies(@RequestBody Movies movies, @PathVariable Integer id) {
        try {
            Movies movieExists = moviesService.findMovieById(id);
            movieExists.setMovieName(movies.getMovieName());
            movieExists.setPlot(movies.getPlot());
            movieExists.setReleaseDate(movies.getReleaseDate());
            movieExists.setIncome(movies.getIncome());
            movieExists.setDuration(movies.getDuration());
            movieExists.setMovieActors(movies.getMovieActors());
            movieExists.setMovieGenres(movies.getMovieGenres());
            movieExists.setMovieDirectors(movies.getMovieDirectors());
            movieExists.setMovieAwards(movies.getMovieAwards());
            movieExists.setMovieScreenwritters(movies.getMovieScreenwritters());
            movieExists.setFavorites(movies.getFavorites());
            return new ResponseEntity<Movies>(movieExists, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Movies>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/movies/{id}")

    public void deleteMovies(@PathVariable Integer id) {
        moviesService.deleteMovie(id);
    }
}
