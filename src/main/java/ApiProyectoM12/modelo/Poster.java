package ApiProyectoM12.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Poster {
    @Id @GeneratedValue
    private Integer id;
    private String url;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_movies")

    private Movies movie;

}
