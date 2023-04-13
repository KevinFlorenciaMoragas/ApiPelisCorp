package ApiProyectoM12.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name="user")
public class User implements UserDetails {
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
    @Builder.Default
    private boolean accountNotExpired = true;
    @Builder.Default
    private boolean accountNotLocked = true;
    @Builder.Default
    private boolean credentialsNotExpired = true;
    @Builder.Default
    private boolean enabled = true;
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<UserRolEnum> rolEnums;
    @CreatedDate
    private LocalDateTime createdAt;
    @Builder.Default
    private LocalDateTime lastPasswordChangeAt = LocalDateTime.now();
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userRol_id")
   // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UserRol userRol;
    @OneToMany(mappedBy = "user")
    Set<Favorite> favorites;
    @OneToMany(mappedBy = "user")
    Set<UserReview> userReviews;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return rolEnums.stream()
                .map(rol -> "ROL_" + rol)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
