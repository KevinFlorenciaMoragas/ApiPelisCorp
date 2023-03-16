package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.Screenwritter;
import ApiProyectoM12.repositorio.SreenwritterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ScreenwritterService {
    @Autowired
    private SreenwritterRepository sreenwritterRepository;

    public List<Screenwritter> listSreenwritter(){return sreenwritterRepository.findAll();}
    public void saveSreenwritter(Screenwritter screenwritter){sreenwritterRepository.save(screenwritter);}
    public Screenwritter findSreenwritterById(Integer id){return sreenwritterRepository.findById(id).get();}
    public void deleteSreenwritter(Integer id){sreenwritterRepository.deleteById(id);}
}
