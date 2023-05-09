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
@Table(name="awards")
public class Awards {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "name", length = 200)
    private String name;
    @Column(name = "festival", length = 200)
    private String festival;

}
