package ApiProyectoM12.modelo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reviews")
public class Reviews {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "text")
    private String text;
    @Column(name = "average_rating")
    private double averageRating;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "moviesUser",
            joinColumns = { @JoinColumn(name = "id_user") },
            inverseJoinColumns = { @JoinColumn(name = "id_review", nullable = false) })
    private List<User> userReviews;

}
