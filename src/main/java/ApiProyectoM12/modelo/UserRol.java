package ApiProyectoM12.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(name="userrol")
public class UserRol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "rol", nullable = false)
    private String rol;

   // @OneToMany( cascade = CascadeType.ALL,mappedBy = "userrol")
   // Set<User> users;

}