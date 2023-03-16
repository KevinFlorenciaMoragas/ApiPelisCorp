package ApiProyectoM12.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="movie_director")
public class MovieDirector {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_movie")
    Movies movies;
    @ManyToOne
    @JoinColumn(name = "id_director")
    Director director;


}
