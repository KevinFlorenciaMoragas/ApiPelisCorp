package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.Awards;
import ApiProyectoM12.modelo.MovieGenre;
import ApiProyectoM12.modelo.Movies;
import ApiProyectoM12.modelo.ScreenwritterAward;
import ApiProyectoM12.repositorio.ScreenwritterAwardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScreenwritterAwardService {
    @Autowired
    private ScreenwritterAwardRepository screenwritterAwardRepository;

    public List<ScreenwritterAward> listScreenwritterAward(){return screenwritterAwardRepository.findAll();}
    public void saveScreenwritterAward(ScreenwritterAward screenwritterAward){screenwritterAwardRepository.save(screenwritterAward);}
    public ScreenwritterAward findScreenwritterAwardById(Integer id){return screenwritterAwardRepository.findById(id).get();}
    public void deleteScreenwritterAward(Integer id){screenwritterAwardRepository.deleteById(id);}

    public List<Awards> getAwardsbyScreenwritter(Integer screenwritterId) {
        List<ScreenwritterAward> movieGenreList = screenwritterAwardRepository.findByScreenwritterId(screenwritterId);
        List<Awards> awards = movieGenreList.stream().map(ScreenwritterAward::getAwards).collect(Collectors.toList());
        return awards;
    }

}
