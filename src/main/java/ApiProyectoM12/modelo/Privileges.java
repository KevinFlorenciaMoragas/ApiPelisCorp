package ApiProyectoM12.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Collection;
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Privileges {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @ManyToMany(mappedBy = "privileges")
    private Collection<UserRol> userRols;
}
