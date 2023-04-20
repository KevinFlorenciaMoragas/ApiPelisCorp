package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.Awards;
import ApiProyectoM12.modelo.DirectorAward;
import ApiProyectoM12.repositorio.DirectorAwardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DirectorAwardService {
    @Autowired
    private DirectorAwardRepository directorAwardRepository;

    public List<DirectorAward> listDirectorAward(){return directorAwardRepository.findAll();}
    public void saveDirectorAward(DirectorAward directorAward){directorAwardRepository.save(directorAward);}
    public DirectorAward findDirectorAwardById(Integer id){return directorAwardRepository.findById(id).get();}
    public void deleteDirectorAward(Integer id){directorAwardRepository.deleteById(id);}

    public List<Awards> getAwardsbyDirector(Long directorId) {
        List<DirectorAward> directorAwardList = directorAwardRepository.findByDirectorId(directorId);
        List<Awards> awards = directorAwardList.stream().map(DirectorAward::getAwards).collect(Collectors.toList());
        return awards;
    }
}
