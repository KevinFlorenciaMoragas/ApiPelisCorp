package ApiProyectoM12.controlador;

import ApiProyectoM12.modelo.User;
import ApiProyectoM12.repositorio.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequiredArgsConstructor

public class SpringSessionController {
    private final UserRepository userRepository;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user, HttpServletRequest request, Model model) {
        System.out.println("Entramos en login");
        try {
            User userExist = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
            if (userExist!= null) {
                System.out.println("Usuario correcto");
                HttpSession session = request.getSession();
                session.setAttribute("username", user.getUsername());
                session.setAttribute("rol", user.getUserRol());
                System.out.println(session.getAttribute("username"));
                return ResponseEntity.ok(userExist);
            } else {
                model.addAttribute("error", "Usuario o contraseña incorrectos");
                System.out.println("Usuario incorrecto");
                return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o contraseña incorrectos");
            }
        } catch (Exception e) {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(@RequestParam (required = false) String error, Model model) {
        if(error!= null)
            model.addAttribute("error", error);
        return "login";
    }
}
