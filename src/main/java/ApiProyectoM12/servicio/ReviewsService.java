package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.Reviews;
import ApiProyectoM12.repositorio.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsService {
    @Autowired
    private ReviewsRepository reviewsRepository;

    public List<Reviews> listReview(){return reviewsRepository.findAll();}
    public void saveReview(Reviews reviews){reviewsRepository.save(reviews);}
    public Reviews findReviewById(Integer id){return reviewsRepository.findById(id).get();}
    public void deleteReview(Integer id){reviewsRepository.deleteById(id);}
}
