package ApiProyectoM12.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Set;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(name="user")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "username", nullable = false, length = 20)
    private String username;
    @Column(name = "password", nullable = false, length = 8000)
    private String password;
    @Column(name = "email", nullable = false, length = 120)
    private String email;

   @Enumerated(EnumType.STRING)
    private Role role;

    /*
    @ManyToMany
    @JoinTable(
        name = "user_rol",
        joinColumns = @JoinColumn(
                name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(
                name = "rol_id", referencedColumnName = "id"))
    private Collection<UserRol> userRoles;

     */
    @OneToMany(mappedBy = "user")
    Set<Favorite> favorites;
    @OneToMany(mappedBy = "user")
    Set<UserReview> userReviews;

}
