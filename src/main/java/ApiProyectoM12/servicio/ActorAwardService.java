package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.ActorAward;
import ApiProyectoM12.modelo.Awards;
import ApiProyectoM12.repositorio.ActorAwardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorAwardService {
    @Autowired
    private ActorAwardRepository actorAwardRepository;

    public List<ActorAward> listActorAward(){return actorAwardRepository.findAll();}
    public void saveActorAward(ActorAward actorAward){actorAwardRepository.save(actorAward);}
    public ActorAward findActorAwardById(Integer id){return actorAwardRepository.findById(id).get();}
    public void deleteActorAward(Integer id){actorAwardRepository.deleteById(id);}

    public List<Awards> getAwardsbyActor(Integer actorid) {
        System.out.println("Actor="+ actorid);
        List<ActorAward> actorAwardList = actorAwardRepository.findByActorsId(actorid);
        System.out.println("ActorAward="+ actorAwardList);
        List<Awards> awards = actorAwardList.stream().map(ActorAward::getAwards).collect(Collectors.toList());
        return awards;
    }
}
