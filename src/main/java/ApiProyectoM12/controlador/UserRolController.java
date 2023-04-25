package ApiProyectoM12.controlador;
/*
import ApiProyectoM12.modelo.User;
import ApiProyectoM12.modelo.UserRol;
import ApiProyectoM12.servicio.UserRolService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class UserRolController {
    @Autowired
    private final UserRolService userRolService;

    @GetMapping("/userRol")
    public List<UserRol> listUserRol(){
        return userRolService.listUserRol();
    }
    @GetMapping("/aliveRol")
    public boolean alive(){
        return true;
    }
    @GetMapping("/userRol/{id}")
    public ResponseEntity<UserRol> getUserRolById(@PathVariable Integer id){
        try{
            UserRol userRol = userRolService.findUserRolById(id);
            return  ResponseEntity.ok(userRol);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/userRol")
    public ResponseEntity<User> newUserRol(@RequestBody UserRol userRol){
        try{
            System.out.println(userRol);
            userRolService.saveUserRol(userRol);
            return null;
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/userRol/{id}")
    public ResponseEntity<?> editUserRol(@RequestBody UserRol userRol, @PathVariable Integer id){
        try {
            UserRol userRolExist = userRolService.findUserRolById(id);
            userRolExist.setRol(userRol.getRol());
            userRolService.saveUserRol(userRolExist);
            return new ResponseEntity<UserRol>(userRolExist,HttpStatus.OK);

        } catch(Exception e){
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/userRol/{id}")

    public void deleteUserRol(@PathVariable Integer id){
        userRolService.deleteUserRol(id);
    }



}
*/