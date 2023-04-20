package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.Privileges;
import ApiProyectoM12.modelo.Reviews;
import ApiProyectoM12.repositorio.PrivilegesRepository;
import ApiProyectoM12.repositorio.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PrivilegesService {
    @Autowired
    private PrivilegesRepository privilegesRepository;

    public List<Privileges> listPrivileges(){return privilegesRepository.findAll();}
    public void savePrivileges(Privileges privileges){privilegesRepository.save(privileges);}
    public Privileges findPrivilegesById(Integer id){return privilegesRepository.findById(id).get();}
    public void deletePrivileges(Integer id){privilegesRepository.deleteById(id);}
}
