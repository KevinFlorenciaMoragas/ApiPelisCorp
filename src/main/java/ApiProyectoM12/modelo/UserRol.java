package ApiProyectoM12.modelo;
/*
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;


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
    @ManyToMany
    @JoinTable(
        name = "roles_privileges",
       joinColumns = @JoinColumn(
               name = "role_id", referencedColumnName = "id"),
         inverseJoinColumns = @JoinColumn(
                 name = "privilege_id", referencedColumnName = "id")
               )
       private Collection<Privileges> privileges;
   }
*/
