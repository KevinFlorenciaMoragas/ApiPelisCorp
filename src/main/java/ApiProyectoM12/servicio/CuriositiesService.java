package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.Awards;
import ApiProyectoM12.modelo.Curiosities;
import ApiProyectoM12.repositorio.AwardsRepository;
import ApiProyectoM12.repositorio.CuriositiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuriositiesService {
    @Autowired
    private CuriositiesRepository curiositiesRepository;

    public List<Curiosities> listCuriosities(){return curiositiesRepository.findAll();}
    public void saveCuriosity(Curiosities curiosities){curiositiesRepository.save(curiosities);}
    public Curiosities findCuriosityById(Integer id){return curiositiesRepository.findById(id).get();}
    public void deleteCuriosity(Integer id){curiositiesRepository.deleteById(id);}
}

