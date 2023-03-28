package ApiProyectoM12.controlador;

import ApiProyectoM12.modelo.User;
import ApiProyectoM12.servicio.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/user")
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
    public ResponseEntity<User> newUser(@RequestBody User user) {
        try {
            System.out.println(user);
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
            userExist.setName(user.getName());
            userExist.setLast_name(user.getLast_name());
            userExist.setUsername(user.getUsername());
            userExist.setPassword(user.getPassword());
            userExist.setEmail(user.getEmail());
            userExist.setUserRol(user.getUserRol());
            userExist.setUserReviews(user.getUserReviews());
            userExist.setFavorites(user.getFavorites());
            // userExist.setId_rol(user.getId_rol());
            userService.saveUser(userExist);
            return new ResponseEntity<User>(userExist, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/user/{id}")

    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
}