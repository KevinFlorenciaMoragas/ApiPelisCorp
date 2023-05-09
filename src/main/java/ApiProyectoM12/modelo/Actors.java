package ApiProyectoM12.modelo;

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
@Table(name="actors")
public class Actors {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "lastName", length = 50)
    private String lastName;

}
