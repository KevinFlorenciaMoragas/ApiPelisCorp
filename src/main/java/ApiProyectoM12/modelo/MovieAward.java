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
@Table(name="movies_awards")
public class MovieAward {
    @Id @GeneratedValue
    private Integer id;
    @Column(name = "date")
    private Date date;
    @Column(name = "nominee_winner")
    private Boolean nomineeWinner;
    @ManyToOne
    @JoinColumn(name = "id_movie")
    Movies movies;
    @ManyToOne
    @JoinColumn(name = "id_award")
    Awards awards;
}
