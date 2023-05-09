package ApiProyectoM12.security;

import ApiProyectoM12.modelo.Role;
import ApiProyectoM12.modelo.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
            List<GrantedAuthority> list = new ArrayList<>();
            System.out.println(user.getUsername());
            if(user.getUsername().equals("admin")){
                list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                System.out.println(list);
            }
            else{
                list.add(new SimpleGrantedAuthority("ROLE_USER"));
                System.out.println(list);
            }
            return list;
    }

    @Override
    public String getPassword() {
        System.out.println("Contraseña " + user.getPassword());
        return user.getPassword();
    }
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
