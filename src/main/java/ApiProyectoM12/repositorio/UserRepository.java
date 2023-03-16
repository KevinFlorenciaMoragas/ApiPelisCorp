package ApiProyectoM12.repositorio;

import ApiProyectoM12.modelo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
