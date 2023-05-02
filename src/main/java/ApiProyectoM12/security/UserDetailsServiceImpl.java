package ApiProyectoM12.security;

import ApiProyectoM12.modelo.Role;
import ApiProyectoM12.modelo.User;
import ApiProyectoM12.repositorio.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Permission;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*Optional<User> userDb = userRepository.findByUsername(username);
        if(userDb.isPresent()){
            User user = userDb.get();
            Role role = user.getRole();
            return org.springframework.security.core.userdetails.User
                    .withUsername(username)
                    .password(user.getPassword())
                    .roles(role.getName())
                    .build();
        }else{
            throw new UsernameNotFoundException("User not found with username: " + username);
        }*/
       User user =  userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new UserDetailsImpl(user);
    }/*
    private Set<SimpleGrantedAuthority> getAuthority(User user){
       Set<SimpleGrantedAuthority> authorities = new java.util.HashSet<>();
       user.getRole().forEach(role -> {
           authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
       });
    }
*/
}
