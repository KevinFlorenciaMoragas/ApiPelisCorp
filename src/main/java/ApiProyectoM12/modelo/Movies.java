package ApiProyectoM12.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="movies")
public class Movies {
    @Id @GeneratedValue
    private Integer id;
    @Column(name="movieName",length = 100)
    private String movieName;
    @Column(name="release_date")
    private Date releaseDate;
    @Column(name="plot", length = 8000)
    private String plot;
    @Column(name = "duration")
    private Long duration;
    @Column(name = "income")
    private Long income;
    @OneToMany(mappedBy = "movies")
    Set<Favorite>favorites;
    @OneToMany(mappedBy = "movies")
    Set<MovieGenre>movieGenres;
    @OneToMany(mappedBy = "movies")
    Set<MovieDirector>movieDirectors;
    @OneToMany(mappedBy = "movies")
    Set<MovieActor>movieActors;
    @OneToMany(mappedBy = "movies")
    Set<MovieAward>movieAwards;
    @OneToMany(mappedBy = "movies")
    Set<MovieScreenwritter>movieScreenwritters;
}
