package ApiProyectoM12.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Privileges {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> userRols;
    public Privileges(String name) {
        this.name = name;
    }
}
