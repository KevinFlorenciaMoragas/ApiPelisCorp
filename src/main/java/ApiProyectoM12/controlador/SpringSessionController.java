package ApiProyectoM12.controlador;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SpringSessionController {

    /*@GetMapping("/")
    public String index(Model model, HttpSession session) {
        @SuppressWarnings("unchecked")
                List<String> messages = (List<String>) session.getAttribute("messages");
        if (messages == null) {
            messages = new ArrayList<>();
        }
        model.addAttribute("messages", messages);
        return "index";
    }
    @PostMapping("/persistMessage")
    public String persistMessage(@RequestParam("msg")String msg, HttpSession session) {
        HttpServletRequest request = (HttpServletRequest) session.getAttribute("request");
        @SuppressWarnings("unchecked")
        List<String> messages = (List<String>) request.getSession().getAttribute("messages");
        if (messages == null) {
            messages = new ArrayList<>();
            request.getSession().setAttribute("messages", msg);
        }
        messages.add(msg);
        request.getSession().setAttribute("messages", messages);
        return "redirect:/";
    }
    @PostMapping("/destroySession")
    public String destroySession(HttpSession session) {
        session.invalidate();
        return "redirect:/index";
    }*/
    @GetMapping("/login")
    public String login(){
        return "index";
    }
    @PostMapping("/login")
    public String doLogin(HttpSession session, String username, String password){
        /*if(username.equals("admin") && password.equals("admin")){
            session.setAttribute("username", username);
            System.out.println("Login correcto");
            return "redirect:/";
        }*/
        System.out.println("Login incorrecto");
        return "redirect:/index";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        System.out.println("Logout correcto");
        return "redirect:/index";
    }
}
