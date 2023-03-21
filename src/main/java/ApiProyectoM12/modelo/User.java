package ApiProyectoM12.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(name="user")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email", nullable = false)
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
