package ApiProyectoM12.repositorio;

import ApiProyectoM12.modelo.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesRepository extends JpaRepository<Movies,Integer> {

}
