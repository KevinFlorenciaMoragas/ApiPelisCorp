package ApiProyectoM12.repositorio;

import ApiProyectoM12.modelo.Actors;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActorsRepository extends JpaRepository<Actors,Integer> {

    @Query("SELECT a FROM Actors a WHERE a.name = ?1 and a.lastname = ?2")
    List<Actors> findByActorName(@Param("name") String name, @Param("lastname") String lastName);
}
