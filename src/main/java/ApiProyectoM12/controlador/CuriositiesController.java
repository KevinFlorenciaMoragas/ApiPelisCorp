package ApiProyectoM12.controlador;

import ApiProyectoM12.modelo.Curiosities;
import ApiProyectoM12.modelo.Director;
import ApiProyectoM12.servicio.CuriositiesService;
import ApiProyectoM12.servicio.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CuriositiesController {
    @Autowired
    private CuriositiesService curiositiesService;
    @GetMapping("/allCuriosities")
    public List<Curiosities> listCuriosities() {
        return curiositiesService.listCuriosities();
    }

    @GetMapping("/curiosity/{id}")
    public ResponseEntity<Curiosities> getCuriosityById(@PathVariable Integer id) {
        try {
            Curiosities curiosities = curiositiesService.findCuriosityById(id);
            return ResponseEntity.ok(curiosities);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/curiosity")
    public ResponseEntity<Curiosities> newCuriosity(@RequestBody Curiosities curiosities) {
        try {
            System.out.println(curiosities);
            curiositiesService.saveCuriosity(curiosities);
            return null;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/curiosity/{id}")
    public ResponseEntity<?> editCuriosity(@RequestBody Curiosities curiosities, @PathVariable Integer id) {
        try {
            Curiosities curiosityExist = curiositiesService.findCuriosityById(id);
            curiosityExist.setCuriosityName(curiosities.getCuriosityName());
            curiosityExist.setCuriosityDescription(curiosities.getCuriosityDescription());

            curiositiesService.saveCuriosity(curiosityExist);

            return new ResponseEntity<Curiosities>(curiosityExist, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<Curiosities>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/curiosity/{id}")

    public void deleteDirector(@PathVariable Integer id) {
        curiositiesService.deleteCuriosity(id);
    }
}
