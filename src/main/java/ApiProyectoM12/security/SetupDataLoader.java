package ApiProyectoM12.security;

import ApiProyectoM12.modelo.Privileges;
import ApiProyectoM12.modelo.UserRol;
import ApiProyectoM12.repositorio.PrivilegesRepository;
import ApiProyectoM12.repositorio.UserRepository;
import ApiProyectoM12.repositorio.UserRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRolRepository roleRepository;
    @Autowired
    private PrivilegesRepository privilegesRepository;

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(alreadySetup)
            return;
        Privileges readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
    }
    @Transactional
    Privileges createPrivilegeIfNotFound(String name) {

        Privileges privilege = privilegesRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privileges();
            privilegesRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    UserRol createRoleIfNotFound(String name, Collection<Privileges> privileges) {

        UserRol role = roleRepository.findByName(name);
        if (role == null) {
            role = new UserRol();
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }
}
