package ApiProyectoM12.security;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.savedrequest.NullRequestCache;

//import static ApiProyectoM12.modelo.Role.ADMIN;

@AllArgsConstructor
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig  {

    private final UserDetailsService userDetailsService;
    private final JWTAuthorizationFilter jwtAuthorizationFilter;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
        JWTAuthenticationFilter filter = new JWTAuthenticationFilter();
        filter.setAuthenticationManager(authenticationManager);
        filter.setFilterProcessesUrl("/login2");
    return http
                .cors().and()
                .csrf().disable()
                .authorizeRequests()
                //.requestMatchers(HttpMethod.POST, "/login2").permitAll()
                .requestMatchers(HttpMethod.GET, "/**")
                //.hasRole("ADMIN")
                .authenticated()
                .requestMatchers(HttpMethod.POST, "/user/**")
                .permitAll()
                .requestMatchers(HttpMethod.POST, "/admin/**")
                .permitAll()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(filter)
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    /*
        return http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().
                authorizeRequests().requestMatchers(HttpMethod.GET, "/**").hasAnyRole("ADMIN", "USER")
                .requestMatchers(HttpMethod.POST, "/user/**").hasAnyRole("ADMIN", "USER")
                .requestMatchers(HttpMethod.POST, "/movies/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/routeB/**").hasRole("ADMIN").and().
                requestCache().requestCache(new NullRequestCache()).and().
                httpBasic().and().
                authorizeRequests().anyRequest().authenticated().and().
                addFilter(filter).addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class).
                csrf().disable().build();
    */
    }


    @Bean
    AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder())

                .and()
                .build();
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("admin"));
    }
}
