package ApiProyectoM12.controlador;

import ApiProyectoM12.modelo.ScreenwritterAward;
import ApiProyectoM12.servicio.ScreenwritterAwardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class ScreenwritterAwardController {
    private final ScreenwritterAwardService screenwritterAwardService;

    @GetMapping("/screenwritterAward")
    public List<ScreenwritterAward> listScreenwritterAward() {return screenwritterAwardService.listScreenwritterAward();
    }

    @GetMapping("/screenwritterAward/{id}")
    public ResponseEntity<ScreenwritterAward> getScreenwritterById(@PathVariable Integer id) {
        try {
            ScreenwritterAward screenwritterAward = screenwritterAwardService.findScreenwritterAwardById(id);
            return ResponseEntity.ok(screenwritterAward);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/screenwritterAward")
    public ResponseEntity<ScreenwritterAward> newScreenwritterAwardAward(@RequestBody ScreenwritterAward screenwritterAward) {
        try {
            System.out.println(screenwritterAward);
            screenwritterAwardService.saveScreenwritterAward(screenwritterAward);
            return null;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/screenwritterAward/{id}")
    public ResponseEntity<?> editScreenwritterAward(@RequestBody ScreenwritterAward screenwritterAward, @PathVariable Integer id) {
        try {
            ScreenwritterAward screenwritterAwardExist = screenwritterAwardService.findScreenwritterAwardById(id);
            screenwritterAwardExist.setDate(screenwritterAward.getDate());
            screenwritterAwardExist.setNomineeWinner(screenwritterAward.getNomineeWinner());
            screenwritterAwardExist.setScreenwritter(screenwritterAward.getScreenwritter());
            screenwritterAwardExist.setAwards(screenwritterAward.getAwards());
            screenwritterAwardService.saveScreenwritterAward(screenwritterAwardExist);
            return new ResponseEntity<ScreenwritterAward>(screenwritterAwardExist, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<ScreenwritterAward>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/screenwritterAward/{id}")

    public void deleteScreenwritterAward(@PathVariable Integer id) {
        screenwritterAwardService.deleteScreenwritterAward(id);
    }
}
