package ApiProyectoM12.controlador;

import ApiProyectoM12.modelo.Actors;
import ApiProyectoM12.modelo.Director;
import ApiProyectoM12.servicio.DirectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequiredArgsConstructor
public class DirectorController {
    private final DirectorService directorService;

    @GetMapping("/allDirector")
    public List<Director> listDirector() {
        return directorService.listDirector();
    }

    @GetMapping("/director/{id}")
    public ResponseEntity<Director> getDirectorById(@PathVariable Integer id) {
        try {
            Director director = directorService.findDirectorById(id);
            return ResponseEntity.ok(director);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/director")
    public List<Director> getDirectorByNameAndLastName(@RequestBody Director director) {
        return directorService.findDirectorByNameAndLastName(director.getName(),director.getLastName());
    }

    @PostMapping("/director")
    public ResponseEntity<Director> newDirector(@RequestBody Director director) {
        try {
            System.out.println(director);
            directorService.saveDirector(director);
            return null;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/director/{id}")
    public ResponseEntity<?> editDirector(@RequestBody Director director, @PathVariable Integer id) {
        try {
            Director directorExist = directorService.findDirectorById(id);
            directorExist.setName(director.getName());
            directorExist.setLastName(director.getLastName());
        //    directorExist.setMovieDirectors(director.getMovieDirectors());
            directorService.saveDirector(directorExist);
            return new ResponseEntity<Director>(directorExist, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<Director>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/director/{id}")

    public void deleteDirector(@PathVariable Integer id) {
        directorService.deleteDirector(id);
    }
}
