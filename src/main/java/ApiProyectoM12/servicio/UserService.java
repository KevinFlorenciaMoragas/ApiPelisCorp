package ApiProyectoM12.servicio;

import ApiProyectoM12.dto.CreateUserRequest;
import ApiProyectoM12.modelo.User;
import ApiProyectoM12.modelo.UserRolEnum;
import ApiProyectoM12.repositorio.UserRepository;
import ApiProyectoM12.security.PasswordEncoderConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private PasswordEncoderConfig passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    public List<User> listUser(){return userRepository.findAll();}
    public User saveUser(CreateUserRequest createUserRequest, EnumSet<UserRolEnum> roles){
        User user = User.builder()
                .username(createUserRequest.getUsername())
                .password(passwordEncoder.passwordEncoder().encode(createUserRequest.getPassword()))
                .email(createUserRequest.getEmail())
                .name(createUserRequest.getName())
                .last_name(createUserRequest.getLast_name())
                .avatar(createUserRequest.getAvatar())
                .rolEnums(roles)
                .build();
    return userRepository.save(user);
    }
    public User createUserWithUserRol(CreateUserRequest createUserRequest){
        System.out.println("El usuario es " +createUserRequest);
        return saveUser(createUserRequest, EnumSet.of(UserRolEnum.USER));
    }
    public User createUserWithAdminRol(CreateUserRequest createUserRequest){
        return saveUser(createUserRequest, EnumSet.of(UserRolEnum.ADMIN));
    }
    public User findUserById(Integer id){return userRepository.findById(id).get();}
    public void deleteUser(Integer id){userRepository.deleteById(id);}
    public User findByUsernameAndPassword(String username, String password){return userRepository.findByUsernameAndPassword(username,password);}
    public User findByUsername(String username){return userRepository.findByUsername(username);}
}
