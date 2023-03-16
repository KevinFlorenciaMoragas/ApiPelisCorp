package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.Director;
import ApiProyectoM12.repositorio.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {
    @Autowired
    private DirectorRepository directorRepository;

    public List<Director> listDirector(){return directorRepository.findAll();}
    public void saveDirector(Director director){directorRepository.save(director);}
    public Director findDirectorById(Integer id){return directorRepository.findById(id).get();}
    public void deleteDirector(Integer id){directorRepository.deleteById(id);}
}
