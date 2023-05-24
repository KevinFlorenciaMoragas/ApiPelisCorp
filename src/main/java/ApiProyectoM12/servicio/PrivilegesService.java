package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.Privilege;
import ApiProyectoM12.repositorio.PrivilegesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PrivilegesService {
    @Autowired
    private PrivilegesRepository privilegesRepository;

    public List<Privilege> listPrivileges(){return privilegesRepository.findAll();}
    public void savePrivileges(Privilege privileges){privilegesRepository.save(privileges);}
    public Privilege findPrivilegesById(Integer id){return privilegesRepository.findById(id).get();}
    public void deletePrivileges(Integer id){privilegesRepository.deleteById(id);}
}
