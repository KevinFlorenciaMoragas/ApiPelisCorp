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
@Table(name = "screenwriter")
public class Screenwritter {
@Id @GeneratedValue
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "lastName")
    private String lastName;
    @OneToMany(mappedBy = "screenwritter")
    Set<MovieScreenwritter> movieScreenwritters;
}
