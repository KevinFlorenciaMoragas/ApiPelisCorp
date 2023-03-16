package ApiProyectoM12.controlador;

import ApiProyectoM12.modelo.Favorite;
import ApiProyectoM12.servicio.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequiredArgsConstructor
public class FavoriteController {
    private final FavoriteService favoriteService;

    @GetMapping("/favorite")
    public List<Favorite> listFavorite() {
        return favoriteService.listFavorite();
    }

    @GetMapping("/favorite/{id}")
    public ResponseEntity<Favorite> getFavoriteById(@PathVariable Integer id) {
        try {
            Favorite favorite = favoriteService.findFavoriteById(id);
            return ResponseEntity.ok(favorite);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/favorite")
    public ResponseEntity<Favorite> newFavorite(@RequestBody Favorite favorite) {
        try {
            System.out.println(favorite);
            favoriteService.saveFavorite(favorite);
            return null;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/favorite/{id}")
    public ResponseEntity<?> editFavorite(@RequestBody Favorite favorite, @PathVariable Integer id) {
        try {
          Favorite favoriteExist = favoriteService.findFavoriteById(id);
            favoriteExist.setUser(favorite.getUser());
            favoriteExist.setMovies(favorite.getMovies());
            favoriteService.saveFavorite(favoriteExist);
            return new ResponseEntity<Favorite>(favoriteExist, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<Favorite>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/favorite/{id}")

    public void deleteFavorite(@PathVariable Integer id) {
        favoriteService.deleteFavorite(id);
    }
}
