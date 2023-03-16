package ApiProyectoM12.controlador;

import ApiProyectoM12.modelo.MovieGenre;
import ApiProyectoM12.servicio.MovieGenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class MovieGenreController {
    @Autowired
    private final MovieGenreService movieGenreService;

    @GetMapping("/movieGenre")
    public List<MovieGenre> listMovieGenre(){
        return movieGenreService.listMovieGenre();
    }
    @GetMapping("/movieGenre/{id}")
    public ResponseEntity<MovieGenre> getMovieGenreById(@PathVariable Integer id){
        try{
            MovieGenre movieGenre = movieGenreService.findMovieGenreById(id);
            return  ResponseEntity.ok(movieGenre);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/movieGenre")
    public ResponseEntity<MovieGenre> newMovieGenre(@RequestBody MovieGenre movieGenre){
        try{
            System.out.println(movieGenre);
            movieGenreService.saveMovieGenre(movieGenre);
            return null;
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/movieGenre/{id}")
    public ResponseEntity<?> editMovieGenre(@RequestBody MovieGenre movieGenre, @PathVariable Integer id){
        try {
            MovieGenre movieGenreExist = movieGenreService.findMovieGenreById(id);
            movieGenreExist.setGenre(movieGenre.getGenre());
            movieGenreExist.setMovies(movieGenre.getMovies());
            movieGenreService.saveMovieGenre(movieGenreExist);
            return new ResponseEntity<MovieGenre>(movieGenreExist,HttpStatus.OK);

        } catch(Exception e){
            return new ResponseEntity<MovieGenre>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/movieGenre/{id}")

    public void deleteMovieGenre(@PathVariable Integer id){
        movieGenreService.deleteMovieGenre(id);
    }


}
