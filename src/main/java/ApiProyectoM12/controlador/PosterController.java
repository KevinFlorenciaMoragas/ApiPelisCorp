package ApiProyectoM12.controlador;

import ApiProyectoM12.modelo.Genre;
import ApiProyectoM12.modelo.Poster;
import ApiProyectoM12.servicio.PosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PosterController {
    @Autowired
    private PosterService posterService;
    @GetMapping("/poster")
    public List<Poster> listPoster() {
        return posterService.listPoster();
    }

    @GetMapping("/poster/{id}")
    public ResponseEntity<Poster> getGenreById(@PathVariable Integer id) {
        try {
            Poster poster = posterService.findPosterById(id);
            return ResponseEntity.ok(poster);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/poster")
    public ResponseEntity<Poster> newPoster(@RequestBody Poster poster) {
        try {
            System.out.println(poster);
            posterService.savePoster(poster);
            return null;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/poster/{id}")
    public ResponseEntity<?> editPoster(@RequestBody Poster poster, @PathVariable Integer id) {
        try {
            Poster posterExist = posterService.findPosterById(id);
            posterExist.setUrl(poster.getUrl());
           // posterExist.setMovie(poster.getMovie());
            return new ResponseEntity<Poster>(posterExist, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<Poster>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/poster/{id}")

    public void deletePoster(@PathVariable Integer id) {
        posterService.deletePoster(id);
    }

}
