package ApiProyectoM12.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

@Configuration
public class DisableWebSecurity {
@Bean
    public WebSecurityCustomizer webSecurityConfiguration() {
    return (web) -> web.ignoring().requestMatchers("/**");
    }
}
