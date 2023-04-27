package ApiProyectoM12.security.auth;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor

public class RegisterRequest {
    private String username;
    private String email;
    private String password;


}
