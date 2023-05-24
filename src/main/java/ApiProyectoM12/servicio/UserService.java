package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.User;
import ApiProyectoM12.repositorio.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> listUser(){return userRepository.findAll();}
    public Optional<User> findUserByUsername(String username){return userRepository.findByUsername(username);}
    public void saveUser(User user){userRepository.save(user);}
    public User findUserById(Integer id){return userRepository.findById(id).get();}
    public void deleteUser(Integer id){userRepository.deleteById(id);}
    //public void findUserByUsernameAndEmail(Integer id){userRepository.findByUsernameAndEmail(id);}
    public User findByUsernameAndPassword(String username, String password){return userRepository.findByUsernameAndPassword(username,password);}
}
