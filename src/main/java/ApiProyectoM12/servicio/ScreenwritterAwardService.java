package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.ScreenwritterAward;
import ApiProyectoM12.repositorio.ScreenwritterAwardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreenwritterAwardService {
    @Autowired
    private ScreenwritterAwardRepository screenwritterAwardRepository;

    public List<ScreenwritterAward> listScreenwritterAward(){return screenwritterAwardRepository.findAll();}
    public void saveScreenwritterAward(ScreenwritterAward screenwritterAward){screenwritterAwardRepository.save(screenwritterAward);}
    public ScreenwritterAward findScreenwritterAwardById(Integer id){return screenwritterAwardRepository.findById(id).get();}
    public void deleteScreenwritterAward(Integer id){screenwritterAwardRepository.deleteById(id);}
}
