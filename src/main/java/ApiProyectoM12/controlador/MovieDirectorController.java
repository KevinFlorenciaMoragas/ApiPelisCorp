package ApiProyectoM12.controlador;

import ApiProyectoM12.modelo.MovieDirector;
import ApiProyectoM12.servicio.MovieDirectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class MovieDirectorController {
    private final MovieDirectorService movieDirectorService;

    @GetMapping("/movieDirector")
    public List<MovieDirector> listMovieDirector() {
        return movieDirectorService.listMovieDirector();
    }

    @GetMapping("/movieDirector/{id}")
    public ResponseEntity<MovieDirector> getMovieDirectorById(@PathVariable Integer id) {
        try {
            MovieDirector movieDirector = movieDirectorService.findMovieDirectorById(id);
            return ResponseEntity.ok(movieDirector);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/movieDirector")
    public ResponseEntity<MovieDirector> newMovieDirector(@RequestBody MovieDirector movieDirector) {
        try {
            System.out.println(movieDirector);
            movieDirectorService.saveMovieDirector(movieDirector);
            return null;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/movieDirector/{id}")
    public ResponseEntity<?> editMovieDirector(@RequestBody MovieDirector movieDirector, @PathVariable Integer id) {
        try {
            MovieDirector movieDirectorExist = movieDirectorService.findMovieDirectorById(id);
            movieDirectorExist.setDirector(movieDirectorExist.getDirector());
            movieDirectorExist.setMovies(movieDirector.getMovies());
            movieDirectorService.saveMovieDirector(movieDirectorExist);
            return new ResponseEntity<MovieDirector>(movieDirectorExist, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<MovieDirector>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/movieDirector/{id}")

    public void deleteMovieDirector(@PathVariable Integer id) {
        movieDirectorService.deleteMovieDirector(id);
    }

}
