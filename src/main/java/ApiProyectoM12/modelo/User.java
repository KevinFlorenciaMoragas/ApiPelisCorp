package ApiProyectoM12.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    private UUID id;

    @Column(name = "name", nullable = false, updatable = false, length = 20)
    private String name;

    @Column(name = "last_name", nullable = false,updatable = false, length = 20)
    private String last_name;
    @Column(name = "username", nullable = false,updatable = false, length = 20)
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
