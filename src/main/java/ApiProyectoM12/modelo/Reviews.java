package ApiProyectoM12.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @OneToMany(mappedBy = "reviews")
    Set<UserReview> userReviews;
    @OneToMany(mappedBy = "reviews")
    Set<MovieReview>movieReviews;
}
