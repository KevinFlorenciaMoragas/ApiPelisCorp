package ApiProyectoM12.repositorio;

import ApiProyectoM12.modelo.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query("SELECT r FROM Role r WHERE r.name = ?1")
    Role findByName(String roleAdmin);
}
