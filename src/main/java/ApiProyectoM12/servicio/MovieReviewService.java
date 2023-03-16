package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.MovieReview;
import ApiProyectoM12.repositorio.MovieReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieReviewService {
    @Autowired
    private MovieReviewRepository movieReviewRepository;
    public List<MovieReview> listMovieReview(){return movieReviewRepository.findAll();}
    public void saveMovieReview(MovieReview movieReview){movieReviewRepository.save(movieReview);}
    public MovieReview findMovieReviewById(Integer id){return movieReviewRepository.findById(id).get();}
    public void deleteMovieReview(Integer id){movieReviewRepository.deleteById(id);}
}
