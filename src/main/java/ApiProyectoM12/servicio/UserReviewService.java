package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.UserReview;
import ApiProyectoM12.repositorio.UserReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserReviewService {
    @Autowired
    private UserReviewRepository userReviewRepository;

    public List<UserReview> listUserReview(){return userReviewRepository.findAll();}
    public void saveUserReview(UserReview userReview){userReviewRepository.save(userReview);}
    public UserReview findUserReviewById(Integer id){return userReviewRepository.findById(id).get();}
    public void deleteUserReview(Integer id){userReviewRepository.deleteById(id);}
}
