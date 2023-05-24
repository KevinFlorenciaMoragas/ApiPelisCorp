package ApiProyectoM12.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User reviewUser;

    @ManyToOne( cascade = CascadeType.PERSIST)
    @JoinColumn(name = "movie_id")
    private Movies movies;

}
