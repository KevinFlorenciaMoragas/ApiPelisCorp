package ApiProyectoM12.repositorio;

import ApiProyectoM12.modelo.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite,Integer> {

    List<Favorite> findFavoritesByUserId(Integer User_id);

}
