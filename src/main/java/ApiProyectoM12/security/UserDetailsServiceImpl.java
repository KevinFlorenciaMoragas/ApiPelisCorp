package ApiProyectoM12.security;

import ApiProyectoM12.modelo.Privileges;
import ApiProyectoM12.modelo.Role;
import ApiProyectoM12.modelo.User;
import ApiProyectoM12.repositorio.RoleRepository;
import ApiProyectoM12.repositorio.UserRepository;
import ApiProyectoM12.servicio.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Transactional
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private MessageSource messages;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        System.out.println("El usuario es " +user.getUsername() + " "+ user.getPassword());
        if(user == null) {
            System.out.println("Entro en null");
            return new org.springframework.security.core.userdetails.User(" ", " ", true, true, true, true, getAuthorites(roleRepository.findAll()));
        }else {
            System.out.println("NO Entro en null");
            System.out.println(getAuthorites(user.getRoles()));
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, getAuthorites(user.getRoles()));
        }
    }


    private Collection<? extends GrantedAuthority> getAuthorites(Collection<Role> roles){
        return getGranthtedAuthorities(getPrivileges(roles));
    }
    private List<String> getPrivileges(Collection<Role> roles){
        List<String> privileges = new ArrayList<>();
        List<Privileges> collection = new ArrayList<>();
        for(Role role : roles){
            collection.addAll(role.getPrivileges());
        }
        for(Privileges item : collection){
            privileges.add(item.getName());
        }
        return privileges;
    }
    private List<GrantedAuthority> getGranthtedAuthorities(List<String> privileges){
        List<GrantedAuthority> authorities = new ArrayList<>();
        for(String privilege : privileges){
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }
}
