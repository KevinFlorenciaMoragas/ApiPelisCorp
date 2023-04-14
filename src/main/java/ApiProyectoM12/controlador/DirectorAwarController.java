package ApiProyectoM12.controlador;

import ApiProyectoM12.modelo.DirectorAward;
import ApiProyectoM12.servicio.DirectorAwardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class DirectorAwarController {
    private final DirectorAwardService directorAwardService;

    @GetMapping("/actorAward")
    public List<DirectorAward> listActorAward() {
        return directorAwardService.listDirectorAward();
    }

    @GetMapping("/actorAward/{id}")
    public ResponseEntity<DirectorAward> getAwardsById(@PathVariable Integer id) {
        try {
            DirectorAward actorAward = directorAwardService.findDirectorAwardById(id);
            return ResponseEntity.ok(actorAward);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/actorAward")
    public ResponseEntity<DirectorAward> newActorAward(@RequestBody DirectorAward actorAward) {
        try {
            System.out.println(actorAward);
            directorAwardService.saveDirectorAward(actorAward);
            return null;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/actorAward/{id}")
    public ResponseEntity<?> editActorAward(@RequestBody DirectorAward directorAward, @PathVariable Integer id) {
        try {
            DirectorAward directorAwardExist = directorAwardService.findDirectorAwardById(id);
            directorAwardExist.setDate(directorAward.getDate());
            directorAwardExist.setNomineeWinner(directorAward.getNomineeWinner());
            directorAwardExist.setActors(directorAward.getActors());
            directorAwardExist.setAwards(directorAward.getAwards());
            directorAwardService.saveDirectorAward(directorAwardExist);
            return new ResponseEntity<DirectorAward>(directorAwardExist, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<DirectorAward>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/actorAward/{id}")

    public void deleteActorAward(@PathVariable Integer id) {
        directorAwardService.deleteDirectorAward(id);
    }
}
