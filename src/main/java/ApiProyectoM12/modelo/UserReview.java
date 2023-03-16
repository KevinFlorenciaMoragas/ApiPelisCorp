package ApiProyectoM12.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_review")
public class UserReview {
    @Id
    @GeneratedValue
    private Integer id;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "id_user")
    User user;
    @ManyToOne
    @JoinColumn(name = "id_review")
    Reviews reviews;
    private double rating;
}
