package ApiProyectoM12.controlador;

import ApiProyectoM12.modelo.Genre;
import ApiProyectoM12.modelo.Screenwritter;
import ApiProyectoM12.servicio.ScreenwritterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequiredArgsConstructor
public class ScreenwritterController {
    private final ScreenwritterService screenwritterService;

    @GetMapping("/screenwritter")
    public List<Screenwritter> listScreenwritter() {
        return screenwritterService.listSreenwritter();
    }

    @GetMapping("/screenwritter/{id}")
    public ResponseEntity<Screenwritter> getScreenwritterById(@PathVariable Integer id) {
        try {
            Screenwritter screenwritter = screenwritterService.findSreenwritterById(id);
            return ResponseEntity.ok(screenwritter);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/screenwritter")
    public ResponseEntity<Screenwritter> newScreenwritter(@RequestBody Screenwritter screenwritter) {
        try {
            System.out.println(screenwritter);
            screenwritterService.saveSreenwritter(screenwritter);
            return null;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/screenwritter/{id}")
    public ResponseEntity<?> editScreenwritter(@RequestBody Screenwritter screenwritter, @PathVariable Integer id) {
        try {
            Screenwritter screenwritterExist = screenwritterService.findSreenwritterById(id);
            screenwritterExist.setName(screenwritter.getName());
            screenwritterExist.setLastName(screenwritter.getLastName());
            screenwritterService.saveSreenwritter(screenwritterExist);
            return new ResponseEntity<Screenwritter>(screenwritterExist, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<Genre>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/screenwritter/{id}")

    public void deleteScreenwritter(@PathVariable Integer id) {
        screenwritterService.deleteSreenwritter(id);
    }
}
