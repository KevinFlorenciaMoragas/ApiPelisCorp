package ApiProyectoM12.controlador;

import ApiProyectoM12.modelo.Awards;
import ApiProyectoM12.servicio.AwardsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class AwardsController {
    private final AwardsService awardsService;

    @GetMapping("/awards")
    public List<Awards> listAwards() {
        return awardsService.listAwards();
    }

    @GetMapping("/awards/{id}")
    public ResponseEntity<Awards> getAwardsById(@PathVariable Integer id) {
        try {
            Awards award = awardsService.findAwardById(id);
            return ResponseEntity.ok(award);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/awards")
    public ResponseEntity<Awards> newAward(@RequestBody Awards awards) {
        try {
            System.out.println(awards);
            awardsService.saveAwards(awards);
            return null;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/awards/{id}")
    public ResponseEntity<?> editAwards(@RequestBody Awards awards, @PathVariable Integer id) {
        try {
            Awards awardsExist = awardsService.findAwardById(id);
            awardsExist.setName(awards.getName());
            awardsExist.setActorAwards(awards.getActorAwards());
            awardsExist.setMovieAwards(awards.getMovieAwards());
            awardsExist.setFestival(awards.getFestival());
            return new ResponseEntity<Awards>(awardsExist, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<Awards>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/awards/{id}")

    public void deleteAwards(@PathVariable Integer id) {
        awardsService.deleteAward(id);
    }
}


