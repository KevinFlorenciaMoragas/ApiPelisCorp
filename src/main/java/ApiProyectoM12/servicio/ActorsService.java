package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.Actors;
import ApiProyectoM12.repositorio.ActorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActorsService {
    @Autowired
    private ActorsRepository actorsRepository;

    public List<Actors> listActors(){return actorsRepository.findAll();}
    public void saveActors(Actors actors){actorsRepository.save(actors);}
    public Actors findActorsById(Integer id){return actorsRepository.findById(id).get();}
    public void deleteActors(Integer id){actorsRepository.deleteById(id);}
}
