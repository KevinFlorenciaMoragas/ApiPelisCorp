package ApiProyectoM12.repositorio;

import ApiProyectoM12.modelo.Director;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectorRepository extends JpaRepository<Director,Integer> {

    @Query("select d from Director d WHERE d.name=?1 OR d.lastName = ?2")
    List<Director> findDirectorByNameAndLastName(String name, String lastName);
}
