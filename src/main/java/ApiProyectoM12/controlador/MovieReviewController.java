package ApiProyectoM12.controlador;


import ApiProyectoM12.modelo.MovieReview;
import ApiProyectoM12.servicio.MovieReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class MovieReviewController {
    private final MovieReviewService movieReviewService;

    @GetMapping("/movieReview")
    public List<MovieReview> listMovieReview() {
        return movieReviewService.listMovieReview();
    }

    @GetMapping("/movieReview/{id}")
    public ResponseEntity<MovieReview> getMovieReviewById(@PathVariable Integer id) {
        try {
            MovieReview movieReview = movieReviewService.findMovieReviewById(id);
            return ResponseEntity.ok(movieReview);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/movieReview")
    public ResponseEntity<MovieReview> newMovieReview(@RequestBody MovieReview movieReview) {
        try {
            System.out.println(movieReview);
            movieReviewService.saveMovieReview(movieReview);
            return null;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/movieReview/{id}")
    public ResponseEntity<?> editMovieReview(@RequestBody MovieReview movieReview, @PathVariable Integer id) {
        try {
            MovieReview movieReviewExist = movieReviewService.findMovieReviewById(id);
            movieReviewExist.setReviews(movieReview.getReviews());
            movieReviewExist.setMovies(movieReview.getMovies());
            return new ResponseEntity<MovieReview>(movieReviewExist, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<MovieReview>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/movieReview/{id}")

    public void deleteMovieReview(@PathVariable Integer id) {
        movieReviewService.deleteMovieReview(id);
    }
}

