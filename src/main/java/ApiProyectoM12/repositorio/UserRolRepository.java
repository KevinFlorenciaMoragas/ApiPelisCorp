package ApiProyectoM12.repositorio;

import ApiProyectoM12.modelo.UserRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRolRepository extends JpaRepository<UserRol,Integer> {
    @Query("select u from UserRol u where u.rol = ?1")
    UserRol findByName(String name);
}
