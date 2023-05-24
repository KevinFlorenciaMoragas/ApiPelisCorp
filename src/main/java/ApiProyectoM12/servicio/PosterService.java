package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.Director;
import ApiProyectoM12.modelo.Poster;
import ApiProyectoM12.repositorio.DirectorRepository;
import ApiProyectoM12.repositorio.PosterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PosterService {
    @Autowired
    private PosterRepository posterRepository;

    public List<Poster> listPoster(){return posterRepository.findAll();}
    public void savePoster(Poster poster){posterRepository.save(poster);}
    public Poster findPosterById(Integer id){return posterRepository.findById(id).get();}
    public void deletePoster(Integer id){posterRepository.deleteById(id);}
}
