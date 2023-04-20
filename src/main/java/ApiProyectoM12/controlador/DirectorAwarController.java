package ApiProyectoM12.controlador;

import ApiProyectoM12.modelo.Awards;
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

    @GetMapping("/directorAward")
    public List<DirectorAward> listDirectorAward() {
        return directorAwardService.listDirectorAward();
    }

    @GetMapping("/directorAward/{id}")
    public ResponseEntity<DirectorAward> getAwardsById(@PathVariable Integer id) {
        try {
            DirectorAward directorAward = directorAwardService.findDirectorAwardById(id);
            return ResponseEntity.ok(directorAward);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{directorId}/directorAward")
    public List<Awards> getAwardsbyDirector(@PathVariable Long directorId) {
        return directorAwardService.getAwardsbyDirector(directorId);
    }
    @PostMapping("/directorAward")
    public ResponseEntity<DirectorAward> newDirectorAward(@RequestBody DirectorAward directorAward) {
        try {
            System.out.println(directorAward);
            directorAwardService.saveDirectorAward(directorAward);
            return null;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/directorAward/{id}")
    public ResponseEntity<?> editDirectorAward(@RequestBody DirectorAward directorAward, @PathVariable Integer id) {
        try {
            DirectorAward directorAwardExist = directorAwardService.findDirectorAwardById(id);
            directorAwardExist.setDate(directorAward.getDate());
            directorAwardExist.setNomineeWinner(directorAward.getNomineeWinner());
            directorAwardExist.setDirector(directorAward.getDirector());
            directorAwardExist.setAwards(directorAward.getAwards());
            directorAwardService.saveDirectorAward(directorAwardExist);
            return new ResponseEntity<DirectorAward>(directorAwardExist, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<DirectorAward>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/directorAward/{id}")

    public void deleteDirectorAward(@PathVariable Integer id) {
        directorAwardService.deleteDirectorAward(id);
    }
}
