package ApiProyectoM12.controlador;

import ApiProyectoM12.modelo.Genre;
import ApiProyectoM12.servicio.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequiredArgsConstructor
public class GenreController {
    private final GenreService genreService;

    @GetMapping("/genre")
    public List<Genre> listGenre() {
        return genreService.listGenre();
    }

    @GetMapping("/genre/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable Integer id) {
        try {
            Genre genre = genreService.findGenreById(id);
            return ResponseEntity.ok(genre);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/genre")
    public ResponseEntity<Genre> newGenre(@RequestBody Genre genre) {
        try {
            System.out.println(genre);
            genreService.saveGenre(genre);
            return null;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/genre/{id}")
    public ResponseEntity<?> editGenre(@RequestBody Genre genre, @PathVariable Integer id) {
        try {
            Genre genreExist = genreService.findGenreById(id);
            genreExist.setGenre(genre.getGenre());
            genreService.saveGenre(genreExist);
            return new ResponseEntity<Genre>(genreExist, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<Genre>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/genre/{id}")

    public void deleteGenre(@PathVariable Integer id) {
        genreService.deleteGenre(id);
    }
}
