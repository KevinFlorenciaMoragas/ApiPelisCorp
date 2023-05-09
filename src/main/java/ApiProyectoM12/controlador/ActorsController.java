package ApiProyectoM12.controlador;

import ApiProyectoM12.modelo.Actors;
import ApiProyectoM12.servicio.ActorsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin
@RestController
@RequiredArgsConstructor
public class ActorsController {
    private final ActorsService actorsService;

    @GetMapping("/allActors")
    public List<Actors> listActors() {
        return actorsService.listActors();
    }

    @GetMapping("/actors/{id}")
    public ResponseEntity<Actors> getActorById(@PathVariable Integer id) {
        try {
            Actors actors = actorsService.findActorsById(id);
            return ResponseEntity.ok(actors);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/actors")
    public List<Actors> getActorByNameAndLastName(@RequestBody Actors actors) {
        return actorsService.findActorsByNameAndLastName(actors.getName(),actors.getLastName());
    }

    @PostMapping("/actors")
    public ResponseEntity<Actors> newActor(@RequestBody Actors actors) {
        try {
            System.out.println(actors);
            actorsService.saveActors(actors);
            return null;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/actors/{id}")
    public ResponseEntity<?> editActors(@RequestBody Actors actors, @PathVariable Integer id) {
        try {
            Actors actorsExist = actorsService.findActorsById(id);
            actorsExist.setName(actors.getName());
            actorsExist.setLastName(actors.getLastName());
        /*    actorsExist.setActorAwards(actors.getActorAwards());
            actorsExist.setMovieActors(actors.getMovieActors());*/
            actorsService.saveActors(actorsExist);
            return new ResponseEntity<Actors>(actorsExist, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<Actors>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/actors/{id}")

    public void deleteActors(@PathVariable Integer id) {
        actorsService.deleteActors(id);
    }
}
