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
@Table(name="awards")
public class Awards {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "name", length = 200)
    private String name;
    @Column(name = "festival", length = 200)
    private String festival;
    @ManyToMany(mappedBy = "actors")
    @JsonBackReference
    private Set<Movies> movies = new HashSet<>();
    @OneToMany(mappedBy = "awards")
    Set<ActorAward>actorAwards;
}
