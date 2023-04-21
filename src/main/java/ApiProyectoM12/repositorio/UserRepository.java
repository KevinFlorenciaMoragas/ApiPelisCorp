package ApiProyectoM12.repositorio;

import ApiProyectoM12.modelo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("SELECT u FROM User u WHERE u.username = ?1 and u.password = ?2")
    User findByUsernameAndPassword(String username, String password);

    @Modifying
    @Query("UPDATE User u SET u.password = :newPassword WHERE u.username = :username AND u.password = :password")
    int updatePassword(@Param("username") String username, @Param("password") String password, @Param("newPassword") String newPassword);
}
