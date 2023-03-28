package ApiProyectoM12.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "last_name", nullable = false, length = 20)
    private String last_name;
    @Column(name = "username", nullable = false, length = 20)
    private String username;
    @Column(name = "password", nullable = false, length = 8000)
    private String password;
    @Column(name = "email", nullable = false, length = 120)
    private String email;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userRol_id")
   // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UserRol userRol;
    @OneToMany(mappedBy = "user")
    Set<Favorite> favorites;
    @OneToMany(mappedBy = "user")
    Set<UserReview> userReviews;

}
