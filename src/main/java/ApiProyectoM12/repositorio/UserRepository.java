package ApiProyectoM12.repositorio;

import ApiProyectoM12.modelo.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("SELECT u FROM User u WHERE u.username = ?1 and u.password = ?2")
    User findByUsernameAndPassword(String username, String password);
    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.password = ?2 WHERE u.username = ?1")
    int updatePassword(String username,String password);
}
