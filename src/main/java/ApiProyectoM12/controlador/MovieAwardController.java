package ApiProyectoM12.controlador;

import ApiProyectoM12.modelo.MovieAward;
import ApiProyectoM12.modelo.Movies;
import ApiProyectoM12.servicio.MovieAwardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequiredArgsConstructor
public class MovieAwardController {
    private final MovieAwardService movieAwardService;

    @GetMapping("/movieAward")
    public List<MovieAward> listMovieAward() {
        return movieAwardService.listMovieAward();
    }

    @GetMapping("/movieAward/{id}")
    public ResponseEntity<MovieAward> getMovieAwardById(@PathVariable Integer id) {
        try {
            MovieAward movieAward = movieAwardService.findMovieAwardById(id);
            return ResponseEntity.ok(movieAward);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/movieAward")
    public ResponseEntity<MovieAward> newMovieAward(@RequestBody MovieAward movieAward) {
        try {
            System.out.println(movieAward);
            movieAwardService.saveMovieAward(movieAward);
            return null;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*@GetMapping("/{awards}/moviesAward")
    public List<Movies> getMoviesbyAwards(@PathVariable String awards) {
        return movieAwardService.getMoviesbyAwards(awards);
    }*/

    @GetMapping("/{id}/moviesAward")
    public List<Movies> getMoviesbyAwardsId(@PathVariable Integer id) {
        return movieAwardService.getmoviesbyAwardsid(id);
    }

    @PutMapping("/movieAward/{id}")
    public ResponseEntity<?> editMovieAward(@RequestBody MovieAward movieAward, @PathVariable Integer id) {
        try {
            MovieAward movieAwardExist = movieAwardService.findMovieAwardById(id);
            movieAwardExist.setDate(movieAward.getDate());
            movieAwardExist.setMovies(movieAward.getMovies());
            movieAwardExist.setAwards(movieAward.getAwards());
            movieAwardExist.setNomineeWinner(movieAward.getNomineeWinner());
            movieAwardService.saveMovieAward(movieAwardExist);
            return new ResponseEntity<MovieAward>(movieAwardExist, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<MovieAward>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/movieAward/{id}")

    public void deleteMovieAward(@PathVariable Integer id) {
        movieAwardService.deleteMovieAward(id);
    }

}
