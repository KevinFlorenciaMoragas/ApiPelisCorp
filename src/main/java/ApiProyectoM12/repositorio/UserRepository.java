package ApiProyectoM12.repositorio;

import ApiProyectoM12.modelo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("SELECT u FROM User u WHERE u.username = ?1 and u.password = ?2")
    User findByUsernameAndPassword(String username, String password);

    Optional<User> findByUsername(String username);
}
