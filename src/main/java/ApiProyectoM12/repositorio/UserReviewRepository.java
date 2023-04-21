package ApiProyectoM12.repositorio;

import ApiProyectoM12.modelo.MovieDirector;
import ApiProyectoM12.modelo.UserReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserReviewRepository extends JpaRepository<UserReview,Integer> {

    List<UserReview> findByUserId(Integer userId);
}
