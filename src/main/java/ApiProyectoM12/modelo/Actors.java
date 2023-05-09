package ApiProyectoM12.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="actors")
public class Actors {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "lastName", length = 50)
    private String lastName;
    @ManyToMany(mappedBy = "actors")
    @JsonBackReference
    private Set<Movies> movies = new HashSet<>();
    /*@OneToMany(mappedBy = "actors")
    Set<ActorAward>actorAwards;*/
}
