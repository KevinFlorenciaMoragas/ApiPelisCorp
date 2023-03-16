package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.Awards;
import ApiProyectoM12.repositorio.AwardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AwardsService {
    @Autowired
    private AwardsRepository awardsRepository;

    public List<Awards> listAwards(){return awardsRepository.findAll();}
    public void saveAwards(Awards awards){awardsRepository.save(awards);}
    public Awards findAwardById(Integer id){return awardsRepository.findById(id).get();}
    public void deleteAward(Integer id){awardsRepository.deleteById(id);}
}