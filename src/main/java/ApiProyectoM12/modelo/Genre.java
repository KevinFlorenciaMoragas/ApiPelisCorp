package ApiProyectoM12.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="genre")
public class Genre {
    @Id @GeneratedValue
    private Integer id;
    @Column(name="genre", length = 100)
    private String genre;
    @ManyToMany(mappedBy = "genre")
    @JsonBackReference
    private Set<Movies> movies = new HashSet<>();
}
