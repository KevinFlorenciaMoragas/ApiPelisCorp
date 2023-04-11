package ApiProyectoM12.repositorio;

import ApiProyectoM12.modelo.MovieGenre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieGenreRepository extends JpaRepository<MovieGenre,Integer> {
    List<MovieGenre> findByGenreId(Long genreId);
}
