package ApiProyectoM12.repositorio;

import ApiProyectoM12.modelo.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PrivilegesRepository extends JpaRepository<Privilege, Integer> {
    @Query("select p from Privilege p where p.name = ?1")
    Privilege findByName(String name);
}
