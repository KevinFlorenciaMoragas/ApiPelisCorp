package ApiProyectoM12.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    /*@Autowired
    private JwtTokenService  jwtTokenService;
    */
    @Override

    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        AuthCredentials authCredentials = new AuthCredentials();
        try {
            authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);

        } catch (IOException e) {

        }
        UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(
                authCredentials.getUsername(),
                authCredentials.getPassword(),
                Collections.emptyList());
        return getAuthenticationManager().authenticate(usernamePAT);
    }
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException , ServletException{
        UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();
        //List<String> roles = jwtTokenService.getRoles(userDetails.getRole());
        String token = TokenUtils.createToken(userDetails.getUsername(),userDetails.getPassword());
        response.addHeader("Authorization", "Bearer " + token);
        response.getWriter().flush();
        super.successfulAuthentication(request,response,chain,authResult);
    }
}
