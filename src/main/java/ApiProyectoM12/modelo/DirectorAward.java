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
@Table(name="actor_award")
public class DirectorAward {
    @Id @GeneratedValue
    private Integer id;
    @Column(name = "date")
    private Date date;
    @Column(name = "nominee_winner")
    private Boolean nomineeWinner;
    @ManyToOne
    @JoinColumn(name = "id_director")
    Actors actors;
    @ManyToOne
    @JoinColumn(name = "id_award")
    Awards awards;
}
