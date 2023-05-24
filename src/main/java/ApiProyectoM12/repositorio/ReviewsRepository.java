package ApiProyectoM12.repositorio;

import ApiProyectoM12.modelo.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewsRepository extends JpaRepository<Reviews,Integer> {
    List<Reviews> findAllByMoviesId(Integer id);
}
