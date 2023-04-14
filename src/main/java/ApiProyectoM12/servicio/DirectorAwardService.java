package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.DirectorAward;
import ApiProyectoM12.repositorio.DirectorAwardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorAwardService {
    @Autowired
    private DirectorAwardRepository directorAwardRepository;

    public List<DirectorAward> listDirectorAward(){return directorAwardRepository.findAll();}
    public void saveDirectorAward(DirectorAward actorAward){directorAwardRepository.save(actorAward);}
    public DirectorAward findDirectorAwardById(Integer id){return directorAwardRepository.findById(id).get();}
    public void deleteDirectorAward(Integer id){directorAwardRepository.deleteById(id);}
}
