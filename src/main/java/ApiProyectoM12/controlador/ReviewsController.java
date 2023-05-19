package ApiProyectoM12.controlador;

import ApiProyectoM12.modelo.Reviews;
import ApiProyectoM12.servicio.ReviewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class ReviewsController {
    private final ReviewsService reviewsService;

    @GetMapping("/reviews")
    public List<Reviews> listReviews() {
        return reviewsService.listReview();
    }

    @GetMapping("/reviews/{id}")
    public ResponseEntity<Reviews> getReviewsById(@PathVariable Integer id) {
        try {
            Reviews reviews = reviewsService.findReviewById(id);
            return ResponseEntity.ok(reviews);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/reviews")
    public ResponseEntity<Reviews> newReviews(@RequestBody Reviews reviews) {
        try {
            System.out.println(reviews);
            reviewsService.saveReview(reviews);

            return null;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/reviews/{id}")
    public ResponseEntity<?> editReviews(@RequestBody Reviews reviews, @PathVariable Integer id) {
        try {
            Reviews reviewsExist = reviewsService.findReviewById(id);
            reviewsExist.setText(reviews.getText());

            reviewsExist.setAverageRating(reviews.getAverageRating());
            reviewsService.saveReview(reviewsExist);
            return new ResponseEntity<Reviews>(reviewsExist, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<Reviews>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/reviews/{id}")

    public void deleteReview(@PathVariable Integer id) {
        reviewsService.deleteReview(id);
    }
}
