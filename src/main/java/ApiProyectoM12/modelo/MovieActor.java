package ApiProyectoM12.modelo;




import java.util.List;


public class MovieActor {

    private Movies movie;
    private List<Actors> actors;

    public MovieActor(Movies movie, List<Actors> actors) {
        this.movie = movie;
        this.actors = actors;
    }

    public Movies getMovie() {
        return movie;
    }

    public void setMovie(Movies movie) {
        this.movie = movie;
    }

    public List<Actors> getActors() {
        return actors;
    }

    public void setActors(List<Actors> actors) {
        this.actors = actors;
    }
}
