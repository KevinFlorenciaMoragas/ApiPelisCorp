package ApiProyectoM12.servicio;

import ApiProyectoM12.modelo.Genre;
import ApiProyectoM12.repositorio.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    public List<Genre> listGenre(){return genreRepository.findAll();}
    public void saveGenre(Genre genre){genreRepository.save(genre);}
    public Genre findGenreById(Integer id){return genreRepository.findById(id).get();}
    public void deleteGenre(Integer id){genreRepository.deleteById(id);}
}
