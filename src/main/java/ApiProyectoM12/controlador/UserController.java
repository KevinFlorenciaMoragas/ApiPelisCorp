package ApiProyectoM12.controlador;

import ApiProyectoM12.dto.CreateUserRequest;
import ApiProyectoM12.dto.UserResponse;
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
/*
    @PostMapping("/user")
    public ResponseEntity<User> newUser(@RequestBody Crea user) {
        try {
            System.out.println(user);
            userService.saveUser(user);
            return null;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
*/
    @PostMapping("/auth/register")
    public ResponseEntity<UserResponse> createUserWithUserRol(@RequestBody CreateUserRequest createUserRequest) {
        try {
            User user = userService.createUserWithUserRol(createUserRequest);
            System.out.println("El user " + user);
            UserResponse userResponse = UserResponse.fromUser(userService.createUserWithUserRol(createUserRequest));
            return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/auth/register/admin")
    public ResponseEntity<UserResponse> createUserWithAdminRol(@RequestBody CreateUserRequest createUserRequest) {
        try {
            User user = userService.createUserWithAdminRol(createUserRequest);

            UserResponse userResponse = UserResponse.fromUser(userService.createUserWithAdminRol(createUserRequest));
            return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
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