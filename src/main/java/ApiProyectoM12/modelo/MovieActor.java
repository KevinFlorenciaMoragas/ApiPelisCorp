package ApiProyectoM12.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
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
