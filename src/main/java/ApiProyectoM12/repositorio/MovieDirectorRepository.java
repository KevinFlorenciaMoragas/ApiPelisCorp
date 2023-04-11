package ApiProyectoM12.repositorio;

import ApiProyectoM12.modelo.MovieDirector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieDirectorRepository extends JpaRepository<MovieDirector,Integer> {

    List<MovieDirector> findByDirectorId(Integer directorId);
}
