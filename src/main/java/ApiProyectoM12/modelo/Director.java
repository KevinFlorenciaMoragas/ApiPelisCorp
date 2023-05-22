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
@Table(name="director")
public class Director {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "lastName", length = 50)
    private String lastName;
    @Column(name = "photo")
    private String photo;
    @Column(name = "biography", length = 8000)
    private String biography;
    @Column(name = "birthPlace", length = 50)
    private String birthPlace;
    @Column(name = "birthDate")
    private Integer birthDate;
}
