package ApiProyectoM12.repositorio;

import ApiProyectoM12.modelo.ScreenwritterAward;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScreenwritterAwardRepository extends JpaRepository<ScreenwritterAward,Integer> {

    List<ScreenwritterAward> findByScreenwritterId(Integer screenwritterId);
}
