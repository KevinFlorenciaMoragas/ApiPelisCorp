package ApiProyectoM12.controlador;

import ApiProyectoM12.modelo.UserReview;
import ApiProyectoM12.servicio.UserReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class UserReviewController {
    private final UserReviewService userReviewService;

    @GetMapping("/userReview")
    public List<UserReview> listUserReview() {
        return userReviewService.listUserReview();
    }

    @GetMapping("/userReview/{id}")
    public ResponseEntity<UserReview> getUserReviewById(@PathVariable Integer id) {
        try {
            UserReview userReview = userReviewService.findUserReviewById(id);
            return ResponseEntity.ok(userReview);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/userReview")
    public ResponseEntity<UserReview> newUserReview(@RequestBody UserReview userReview) {
        try {
            System.out.println(userReview);
            userReviewService.saveUserReview(userReview);
            return null;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/userReview/{id}")
    public ResponseEntity<?> editUserReview(@RequestBody UserReview userReview, @PathVariable Integer id) {
        try {
            UserReview userReviewExist = userReviewService.findUserReviewById(id);
            userReviewExist.setReviews(userReview.getReviews());
            userReviewExist.setUser(userReview.getUser());
            userReviewExist.setRating(userReview.getRating());
            userReviewExist.setDate(userReview.getDate());
            return new ResponseEntity<UserReview>(userReviewExist, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<UserReview>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/userReview/{id}")

    public void deleteUserReview(@PathVariable Integer id) {
        userReviewService.deleteUserReview(id);
    }
}