package ApiProyectoM12.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="genre")
public class Genre {
    @Id @GeneratedValue
    private Integer id;
    @Column(name="genre")
    private String genre;
    @OneToMany(mappedBy = "genre")
    Set<MovieGenre> movieGenres;

}
