package ApiProyectoM12.repositorio;

import ApiProyectoM12.modelo.Privileges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PrivilegesRepository extends JpaRepository<Privileges, Integer> {
    @Query("select p from Privileges p where p.name = ?1")
    Privileges findByName(String name);
}
