package ApiProyectoM12.repositorio;

import ApiProyectoM12.modelo.MovieAward;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieAwardRepository extends JpaRepository<MovieAward,Integer> {
    List<MovieAward> findByAwardName(String awardName);
}
