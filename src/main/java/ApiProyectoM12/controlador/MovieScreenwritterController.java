package ApiProyectoM12.controlador;

import ApiProyectoM12.modelo.MovieScreenwritter;
import ApiProyectoM12.servicio.MovieScreenwritterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequiredArgsConstructor
public class MovieScreenwritterController
{
    private final MovieScreenwritterService movieScreenwritterService;

    @GetMapping("/movieScreenwritter")
    public List<MovieScreenwritter> listMovieScreenwritter() {
        return movieScreenwritterService.listMovieScreenwritter();
    }

    @GetMapping("/movieScreenwritter/{id}")
    public ResponseEntity<MovieScreenwritter> getMovieScreenwritterById(@PathVariable Integer id) {
        try {
            MovieScreenwritter movieScreenwritter = movieScreenwritterService.findMovieScreenwritterById(id);
            return ResponseEntity.ok(movieScreenwritter);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/movieScreenwritter")
    public ResponseEntity<MovieScreenwritter> newMovieScreenwritter(@RequestBody MovieScreenwritter movieScreenwritter) {
        try {
            System.out.println(movieScreenwritter);
            movieScreenwritterService.saveMovieScreenwritter(movieScreenwritter);
            return null;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/movieScreenwritter/{id}")
    public ResponseEntity<?> editMovieScreenwritter(@RequestBody MovieScreenwritter movieScreenwritter, @PathVariable Integer id) {
        try {
            MovieScreenwritter movieScreenwritterExist = movieScreenwritterService.findMovieScreenwritterById(id);
            movieScreenwritterExist.setScreenwritter(movieScreenwritterExist.getScreenwritter());
            movieScreenwritterExist.setMovies(movieScreenwritterExist.getMovies());

            return new ResponseEntity<MovieScreenwritter>(movieScreenwritterExist, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<MovieScreenwritter>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/movieScreenwritter/{id}")

    public void deleteMovieScreenwritter(@PathVariable Integer id) {
        movieScreenwritterService.deleteMovieScreenwritter(id);
    }
}
