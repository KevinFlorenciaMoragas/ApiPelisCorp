package ApiProyectoM12.repositorio;

import ApiProyectoM12.modelo.MovieReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieReviewRepository extends JpaRepository<MovieReview,Integer> {
}
