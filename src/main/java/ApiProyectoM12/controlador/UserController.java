package ApiProyectoM12.controlador;

import ApiProyectoM12.modelo.User;
import ApiProyectoM12.servicio.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ApiProyectoM12.modelo.Role.ADMIN;
import static ApiProyectoM12.modelo.Role.USER;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @GetMapping("/user")
 //   @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<User> listUser() {
        return userService.listUser();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        try {
            User user = userService.findUserById(id);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/user")
   // @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<User> newUser(@RequestBody User user) {
        try {
            System.out.println(user);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
           // user.setRole(ROLE_USER);
            userService.saveUser(user);
            return null;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/admin")
    public ResponseEntity<User> newAdmin(@RequestBody User user) {
        try {
            System.out.println(user);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
          //  user.setRole(ROLE_ADMIN);
            userService.saveUser(user);
            return null;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<?> editUser(@RequestBody User user, @PathVariable Integer id) {
        try {
            User userExist = userService.findUserById(id);

            userExist.setUsername(user.getUsername());
            userExist.setPassword(user.getPassword());
            userExist.setEmail(user.getEmail());
          //  userExist.setRole(user.getRole());
            userExist.setUserReviews(user.getUserReviews());
            userExist.setFavorites(user.getFavorites());
            userService.saveUser(userExist);
            return new ResponseEntity<User>(userExist, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/user/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
}