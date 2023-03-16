package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.Favorite;
import ApiProyectoM12.repositorio.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FavoriteService {
    @Autowired
    private FavoriteRepository favoriteRepository;

    public List<Favorite> listFavorite(){return favoriteRepository.findAll();}
    public void saveFavorite(Favorite favorite){favoriteRepository.save(favorite);}
    public Favorite findFavoriteById(Integer id){return favoriteRepository.findById(id).get();}
    public void deleteFavorite(Integer id){favoriteRepository.deleteById(id);}
}
