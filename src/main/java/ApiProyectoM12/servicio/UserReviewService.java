package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.MovieDirector;
import ApiProyectoM12.modelo.Movies;
import ApiProyectoM12.modelo.Reviews;
import ApiProyectoM12.modelo.UserReview;
import ApiProyectoM12.repositorio.UserReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserReviewService {
    @Autowired
    private UserReviewRepository userReviewRepository;

    public List<UserReview> listUserReview(){return userReviewRepository.findAll();}
    public void saveUserReview(UserReview userReview){userReviewRepository.save(userReview);}
    public UserReview findUserReviewById(Integer id){return userReviewRepository.findById(id).get();}
    public void deleteUserReview(Integer id){userReviewRepository.deleteById(id);}

    public List<Reviews> findByUserId(Integer userId) {
        List<UserReview> reviewUserList = userReviewRepository.findByUserId(userId);
        List<Reviews> review = reviewUserList.stream().map(UserReview::getReviews).collect(Collectors.toList());
        return review;
    }
}
