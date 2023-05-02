package ApiProyectoM12.security;

import ApiProyectoM12.modelo.Role;
import lombok.Data;

@Data
public class AuthCredentials {
    private String username;
    private String password;
    private Role role;
}
