package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.User;
import ApiProyectoM12.repositorio.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> listUser(){return userRepository.findAll();}
    public void saveUser(User user){userRepository.save(user);}
    public User findUserById(Integer id){return userRepository.findById(id).get();}
    public void deleteUser(Integer id){userRepository.deleteById(id);}
    public User findByUsernameAndPassword(String username, String password){return userRepository.findByUsernameAndPassword(username,password);}
    public boolean updatePassword(String username, String password, String newpassword) {
        int filasActualizadas = userRepository.updatePassword(username, password, newpassword);
        return filasActualizadas > 0;
    }
}
