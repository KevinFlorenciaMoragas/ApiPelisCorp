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
@Table(name = "screenwriter")
public class Screenwritter {
@Id @GeneratedValue
    private Integer id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "lastName", length = 50)
    private String lastName;
    @ManyToMany(mappedBy = "screenwriter")
    @JsonBackReference
    private Set<Movies> movies = new HashSet<>();
}
