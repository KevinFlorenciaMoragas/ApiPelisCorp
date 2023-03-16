package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.ActorAward;
import ApiProyectoM12.repositorio.ActorAwardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActorAwardService {
    @Autowired
    private ActorAwardRepository actorAwardRepository;

    public List<ActorAward> listActorAward(){return actorAwardRepository.findAll();}
    public void saveActorAward(ActorAward actorAward){actorAwardRepository.save(actorAward);}
    public ActorAward findActorAwardById(Integer id){return actorAwardRepository.findById(id).get();}
    public void deleteActorAward(Integer id){actorAwardRepository.deleteById(id);}
}
