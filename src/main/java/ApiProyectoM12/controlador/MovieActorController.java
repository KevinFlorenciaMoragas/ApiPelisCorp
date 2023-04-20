package ApiProyectoM12.controlador;

import ApiProyectoM12.modelo.MovieActor;
import ApiProyectoM12.modelo.Movies;
import ApiProyectoM12.servicio.MovieActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequiredArgsConstructor
public class MovieActorController {
    private final MovieActorService movieActorService;

    @GetMapping("/movieActor")
    public List<MovieActor> listMovieActor() {
        return movieActorService.listMovieActor();
    }

    @GetMapping("/movieActor/{id}")
    public ResponseEntity<MovieActor> getMovieActorById(@PathVariable Integer id) {
        try {
            MovieActor movieActor = movieActorService.findMovieActorById(id);
            return ResponseEntity.ok(movieActor);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{actorId}/movieActor")
    public List<Movies> getMoviesByActor(@PathVariable Integer actorId) {
        return movieActorService.getMoviesByActor(actorId);
    }

    @GetMapping("/{actorId}/moviesActorASC")
    public List<Movies> findMoviesByActorIdOrderByScoreAsc(@PathVariable Integer actorId) {
        return movieActorService.findMoviesByActorIdOrderByScoreAsc(actorId);
    }

    @GetMapping("/{actorId}/moviesActorDESC")
    public List<Movies> findMoviesByActorIdOrderByScoreDesc(@PathVariable Integer actorId) {
        return movieActorService.findMoviesByActorIdOrderByScoreDesc(actorId);
    }
    @PostMapping("/movieActor")
    public ResponseEntity<MovieActor> newMovieActor(@RequestBody MovieActor movieActor) {
        try {
            System.out.println(movieActor);
            movieActorService.saveMovieActor(movieActor);
            return null;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/movieActor/{id}")
    public ResponseEntity<?> editMovieActor(@RequestBody MovieActor movieActor, @PathVariable Integer id) {
        try {
            MovieActor movieActorExist = movieActorService.findMovieActorById(id);
            movieActorExist.setActors(movieActor.getActors());
            movieActorExist.setMovies(movieActor.getMovies());
            movieActorService.saveMovieActor(movieActorExist);
            return new ResponseEntity<MovieActor>(movieActorExist, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<MovieActor>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/movieActor/{id}")

    public void deleteMovieActor(@PathVariable Integer id) {
        movieActorService.deleteMovieActor(id);
    }

}
