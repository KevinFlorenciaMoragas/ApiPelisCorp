package ApiProyectoM12.controlador;

import ApiProyectoM12.modelo.ActorAward;
import ApiProyectoM12.modelo.Awards;
import ApiProyectoM12.servicio.ActorAwardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequiredArgsConstructor
public class ActorAwarController {
    private final ActorAwardService actorAwardService;

    @GetMapping("/actorAward")
    public List<ActorAward> listActorAward() {
        return actorAwardService.listActorAward();
    }

    @GetMapping("/actorAward/{id}")
    public ResponseEntity<ActorAward> getAwardsById(@PathVariable Integer id) {
        try {
            ActorAward actorAward = actorAwardService.findActorAwardById(id);
            return ResponseEntity.ok(actorAward);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{actorAwardId}/actorAward")
    public List<Awards> getAwardsbyActor(@PathVariable Integer id_actor) {
        return actorAwardService.getAwardsbyActor(id_actor);
    }

    @PostMapping("/actorAward")
    public ResponseEntity<ActorAward> newActorAward(@RequestBody ActorAward actorAward) {
        try {
            System.out.println(actorAward);
            actorAwardService.saveActorAward(actorAward);
            return null;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/actorAward/{id}")
    public ResponseEntity<?> editActorAward(@RequestBody ActorAward actorAward, @PathVariable Integer id) {
        try {
            ActorAward actorAwardExist = actorAwardService.findActorAwardById(id);
            actorAwardExist.setDate(actorAward.getDate());
            actorAwardExist.setNomineeWinner(actorAward.getNomineeWinner());
            actorAwardExist.setActors(actorAward.getActors());
            actorAwardExist.setAwards(actorAward.getAwards());
            actorAwardService.saveActorAward(actorAwardExist);
            return new ResponseEntity<ActorAward>(actorAwardExist, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<ActorAward>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/actorAward/{id}")

    public void deleteActorAward(@PathVariable Integer id) {
        actorAwardService.deleteActorAward(id);
    }
}
