package ApiProyectoM12.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="movie_actor")
public class MovieActor {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_movie")
    Movies movies;
    @ManyToOne
    @JoinColumn(name = "id_actor")
    Actors actors;
}
