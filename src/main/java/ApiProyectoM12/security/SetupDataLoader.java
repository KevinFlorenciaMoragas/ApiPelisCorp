package ApiProyectoM12.security;

import ApiProyectoM12.modelo.Privileges;
import ApiProyectoM12.modelo.Role;
import ApiProyectoM12.modelo.User;
import ApiProyectoM12.repositorio.PrivilegesRepository;
import ApiProyectoM12.repositorio.RoleRepository;
import ApiProyectoM12.repositorio.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PrivilegesRepository privilegesRepository;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(alreadySetup)
            return;
        Privileges readPrivilege
                = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privileges writePrivilege
                = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
        List<Privileges> adminPrivileges = Arrays.asList(readPrivilege,writePrivilege);
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));
        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        User user = new User();
        user = userRepository.findByUsernameSetup("admin");
        if(user != null)
            return;
        else{
            user = new User();
            user.setUsername("admin");
            user.setEmail("admin@admin.com");
            user.setPassword(passwordEncoder.encode("admin"));
            user.setRoles(Arrays.asList(adminRole));
            userRepository.save(user);
            alreadySetup = true;
        }

    }
    @Transactional
    Privileges createPrivilegeIfNotFound(String name) {

        Privileges privilege = privilegesRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privileges(name);
            privilegesRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    Role createRoleIfNotFound(String name, Collection<Privileges> privileges) {
        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }

}
