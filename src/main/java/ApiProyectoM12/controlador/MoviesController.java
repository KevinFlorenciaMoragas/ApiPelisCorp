package ApiProyectoM12.controlador;

import ApiProyectoM12.DTO.MovieDTO;
import ApiProyectoM12.DTO.ReviewDTO;
import ApiProyectoM12.modelo.*;
import ApiProyectoM12.servicio.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class MoviesController {
    private final MoviesService moviesService;
    private final ReviewsService reviewsService;
    private final UserService userService;
    private final ActorsService actorsService;
    private final DirectorService directorService;
    private final ScreenwritterService screenwriterService;
    private final GenreService genreService;
    private final PosterService posterService;

/*
    @PostMapping(value = "/movies/{movieId}/reviews/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createReview(@PathVariable Integer movieId, @PathVariable Integer userId, @RequestBody Reviews review) {
        System.out.printf("CREATE REVIEW");
        try {
            Optional<Movies> optionalMovie = moviesService.findMoviesById(movieId);
            System.out.println("Movies " + optionalMovie.get().getMovieName());
            User user = userService.findUserById(userId);
            System.out.println("User " + user.getUsername());
            Movies movie = optionalMovie.get();
            System.out.println("Movie " + movie.getMovieName());
            review.setMovies(movie);
            System.out.println("Review " + review.getText());
            review.setReviewUser(user);
            movie.getReviews().add(review);
            user.getReviews().add(review);
            moviesService.saveMovie(movie);
            reviewsService.saveReview(review);
            userService.saveUser(user);
           // return ResponseEntity.ok(movie);
        } catch (EntityNotFoundException e) {
           // return ResponseEntity.notFound().build();
        }
    }
*/
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/movies/reviews/", consumes = MediaType.APPLICATION_JSON_VALUE,produces =MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> createReview(@RequestBody ReviewDTO review) {
        try {
            System.out.println("CREATE REVIEW");
            List <Reviews> reviews = new ArrayList<>();
            Reviews newReview = new Reviews();
            newReview.setText(review.getText());
            newReview.setAverageRating(review.getAverageRating());
            User user = userService.findUserById(review.getId_user());
            Movies movie = moviesService.findMovieById(review.getId_movie());
            newReview.setReviewUser(user);
            newReview.setMovies(movie);
            reviews.add(newReview);
            user.setReviews(reviews);
            movie.setReviews(reviews);
            userService.saveUser(user);
            return ResponseEntity.ok().build() ;
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value ="/allDataMovies", consumes = MediaType.APPLICATION_JSON_VALUE,produces =MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<?> createMovie(@RequestBody MovieDTO movieDTO) {
        try {
            System.out.println("CREATE MOVIE");
            Movies movie = new Movies();
            movie.setMovieName(movieDTO.getMovieName());
            movie.setReleaseDate(movieDTO.getReleaseDate());
            movie.setDuration(movieDTO.getDuration());
            movie.setPlot(movieDTO.getPlot());
            movie.setScore(movieDTO.getScore());
            List<Actors> actorsList = new ArrayList<>();
            for (int i = 0; i < movieDTO.getId_actors().size(); i++) {
                Actors actor = actorsService.findActorsById(movieDTO.getId_actors().get(i));
                if(actor != null){
                    actorsList.add(actor);
                }
            }
            movie.setActors(actorsList);
            List<Genre> genresList = new ArrayList<>();
            for (int i = 0; i < movieDTO.getId_genre().size(); i++) {
                Genre genre = genreService.findGenreById(movieDTO.getId_genre().get(i));
                if(genre != null){
                    genresList.add(genre);
                }
            }
            movie.setGenre(genresList);
            List<Director> directorsList = new ArrayList<>();
            for (int i = 0; i < movieDTO.getId_director().size(); i++) {
                Director director = directorService.findDirectorById(movieDTO.getId_director().get(i));
                if(director != null){
                    directorsList.add(director);
                }
            }
            movie.setDirector(directorsList);
            List<Screenwritter> screenwrittersList = new ArrayList<>();
            for (int i = 0; i < movieDTO.getId_screenwritter().size(); i++) {
                Screenwritter screenwritter = screenwriterService.findSreenwritterById(movieDTO.getId_screenwritter().get(i));
                if(screenwritter != null){
                    screenwrittersList.add(screenwritter);
                }
            }
            movie.setScreenwritter(screenwrittersList);
            List<Poster> postersList = new ArrayList<>();
            for (int i = 0; i < movieDTO.getId_poster().size(); i++) {
                Poster poster = posterService.findPosterById(movieDTO.getId_poster().get(i));
                if(poster != null){
                    postersList.add(poster);
                }
            }
            movie.setPoster(postersList);
            movie.setTrailer(movieDTO.getTrailer());
            movie.setBanner(movieDTO.getBanner());
            moviesService.saveMovie(movie);
             /*   List<Poster> posters = new ArrayList<>();
            Poster poster = new Poster();
            for (int i = 0; i < movie.getPoster().size(); i++) {
                poster.setUrl(movie.getPoster().get(i).getUrl());
                posters.add(poster);
//            }*/
//            //poster.setUrl(movieDTO.getPoster().get(0).getUrl());
           /* movie.setDirector(movieDTO.getDirectors());
            movie.setTrailer(movieDTO.getTrailer());
            movie.setBanner(movieDTO.getBanner());
            movie.setScreenwritter(movieDTO.getScreenwritters());
            movie.setActors(movieDTO.getActors());
            movie.setGenre(movieDTO.getGenre());
           */
            return ResponseEntity.ok().build() ;
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }
    @GetMapping("/allMovies")
    public List<Movies> listFavorite() {

        return moviesService.listMovies();
    }
    @GetMapping("/moviesByDirector/{id}")
    public List<Movies> getMovieByDirector(@PathVariable Integer id) {
        return moviesService.findMoviesByDirector(id);
    }
    @GetMapping("/moviesByActor/{id}")
    public List<Movies> getMovieByActor(@PathVariable Integer id) {
        return moviesService.findMoviesByActor(id);
    }
    @GetMapping("/moviesByScreenwritter/{id}")
    public List<Movies> getMovieByScreenwritter(@PathVariable Integer id) {
        return moviesService.findMoviesScreenwritter(id);
    }


    @GetMapping("/movies/{id}")
    public ResponseEntity<Movies> getMovieById(@PathVariable Integer id) {
        try {
            Movies movie = moviesService.findMovieById(id);
            return ResponseEntity.ok(movie);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/movies/topDesc")
    public List<Movies> getTopMovieDesc() {
        List<Movies> movies = moviesService.findTopByOrderByScoreDesc();
            return movies;
            //return ResponseEntity.ok(movie);
    }


    @GetMapping("/movies/topAsc")
    public List<Movies> getTopMovieAsc() {
        List<Movies> movies = moviesService.findTopByOrderByScoreAsc();
        return movies;
    }
   /* @GetMapping("/movies/{releaseDate}")
    public List<Movies> getMovieByReleaseDate(@PathVariable Date releaseDate) {
        return moviesService.findMoviesByReleaseDate(releaseDate);
        //return ResponseEntity.ok(movie);
    }*/
    @GetMapping("/moviesByMovieName/{movieName}")
    public List<Movies> getMovieByMovieName(@PathVariable String movieName) {
        System.out.println(movieName);
        return moviesService.findMoviesByMovieName(movieName);

        //return ResponseEntity.ok(movie);
    }

    @PostMapping("/movies")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Movies> newMovies(@RequestBody Movies movies) {
        try {
            System.out.println(movies);
            moviesService.saveMovie(movies);
            return null;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

   /* @PostMapping("/movie/review/{id}")
    public void addReview(@PathVariable Integer id, @RequestBody Reviews review) {
        Movies movie = moviesService.findMovieById(id);
        movie.getReviews().add(review);
        moviesService.saveMovie(movie);


    }*/

    @PutMapping("/movies/{id}")
    public ResponseEntity<?> editMovies(@RequestBody Movies movies, @PathVariable Integer id) {
        try {
            Movies movieExists = moviesService.findMovieById(id);
            movieExists.setMovieName(movies.getMovieName());
            movieExists.setPlot(movies.getPlot());
            movieExists.setReleaseDate(movies.getReleaseDate());
            movieExists.setIncome(movies.getIncome());
            movieExists.setDuration(movies.getDuration());

            moviesService.saveMovie(movieExists);
            return new ResponseEntity<Movies>(movieExists, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Movies>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/movies/{id}")

    public void deleteMovies(@PathVariable Integer id) {
        moviesService.deleteMovie(id);
    }
    /*
    @GetMapping("/movies/{id_movie}")
    public ResponseEntity<AllMovie> getRolesByUserId(@PathVariable Integer id_movie){
        Optional<Movies> optionalMovie = moviesService.findMoviesById(id_movie);
        if (optionalMovie.isPresent()) {
            Movies movie = optionalMovie.get();
            AllMovie response = new AllMovie(movie);
            return ResponseEntity.ok(response);
        } else {
            throw new EntityNotFoundException("Movie with ID " + id_movie + " not found");
        }
    }*/
    @GetMapping("/movies/genre/{id}")
    public ResponseEntity<List<Movies>> getMovieByGenre(@PathVariable Integer id) {
        try{
            List<Movies> movie = moviesService.findMoviesByGenreId(id);
            return ResponseEntity.ok(movie);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
