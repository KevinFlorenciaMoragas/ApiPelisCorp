package ApiProyectoM12.repositorio;

import ApiProyectoM12.modelo.Actors;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;



import java.util.List;

public interface ActorsRepository extends JpaRepository<Actors,Integer> {

    @Query("select a from Actors a WHERE a.name=?1 AND a.lastName = ?2")
    List<Actors> findActorsByNameAndLastName(String name, String lastName);

}
