package ApiProyectoM12.controlador;

import ApiProyectoM12.modelo.Movies;
import ApiProyectoM12.servicio.MoviesService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class MoviesController {
    private final MoviesService moviesService;

    @GetMapping("/allMovies")
    public List<Movies> listFavorite() {

        return moviesService.listMovies();
    }
    @GetMapping("/moviesByDirector/{id}")
    public List<Movies> getMovieByDirector(@PathVariable Integer id) {
        return moviesService.findMoviesByDirector(id);
    }
    @GetMapping("/moviesByActor/{id}")
    public List<Movies> getMovieByActor(@PathVariable Integer id) {
        return moviesService.findMoviesByActor(id);
    }
    @GetMapping("/moviesByScreenwritter/{id}")
    public List<Movies> getMovieByScreenwritter(@PathVariable Integer id) {
        return moviesService.findMoviesScreenwritter(id);
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


    @GetMapping("/movies/topDesc")
    public List<Movies> getTopMovieDesc() {
        List<Movies> movies = moviesService.findTopByOrderByScoreDesc();
            return movies;
            //return ResponseEntity.ok(movie);
    }


    @GetMapping("/movies/topAsc")
    public List<Movies> getTopMovieAsc() {
        List<Movies> movies = moviesService.findTopByOrderByScoreAsc();
        return movies;
    }
   /* @GetMapping("/movies/{releaseDate}")
    public List<Movies> getMovieByReleaseDate(@PathVariable Date releaseDate) {
        return moviesService.findMoviesByReleaseDate(releaseDate);
        //return ResponseEntity.ok(movie);
    }*/
    @GetMapping("/moviesByMovieName/{movieName}")
    public List<Movies> getMovieByMovieName(@PathVariable String movieName) {
        System.out.println(movieName);
        return moviesService.findMoviesByMovieName(movieName);

        //return ResponseEntity.ok(movie);
    }

    @PostMapping("/movies")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
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

            moviesService.saveMovie(movieExists);
            return new ResponseEntity<Movies>(movieExists, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Movies>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/movies/{id}")

    public void deleteMovies(@PathVariable Integer id) {
        moviesService.deleteMovie(id);
    }
    /*
    @GetMapping("/movies/{id_movie}")
    public ResponseEntity<AllMovie> getRolesByUserId(@PathVariable Integer id_movie){
        Optional<Movies> optionalMovie = moviesService.findMoviesById(id_movie);
        if (optionalMovie.isPresent()) {
            Movies movie = optionalMovie.get();
            AllMovie response = new AllMovie(movie);
            return ResponseEntity.ok(response);
        } else {
            throw new EntityNotFoundException("Movie with ID " + id_movie + " not found");
        }
    }*/
    @GetMapping("/movies/genre/{id}")
    public ResponseEntity<List<Movies>> getMovieByGenre(@PathVariable Integer id) {
        try{
            List<Movies> movie = moviesService.findMoviesByGenreId(id);
            return ResponseEntity.ok(movie);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
