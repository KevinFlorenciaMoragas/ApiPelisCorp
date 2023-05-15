package ApiProyectoM12.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Curiosities {
    @GeneratedValue
    @Id
    private Integer id;
    private String curiosityName;
    private String curiosityDescription;
    @ManyToOne
    private Movies movies;

}
