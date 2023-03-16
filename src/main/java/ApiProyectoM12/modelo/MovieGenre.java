package ApiProyectoM12.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="movie_genre")
public class MovieGenre {
    @Id @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_movie")
    Movies movies;
    @ManyToOne
    @JoinColumn(name = "id_genre")
    Genre genre;
}
