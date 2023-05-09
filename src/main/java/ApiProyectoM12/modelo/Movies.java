package ApiProyectoM12.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="movies")
public class Movies {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "movieName", length = 100)
    private String movieName;
    @Column(name = "release_date")
    private Date releaseDate;
    @Column(name = "plot", length = 8000)
    private String plot;
    @Column(name = "duration")
    private Long duration;
    @Column(name = "income")
    private Long income;
    @Column(name = "score")
    private Double score;
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    @JoinTable(name = "moviesActors",
            joinColumns = { @JoinColumn(name = "id_movies") },
            inverseJoinColumns = { @JoinColumn(name = "id_actors", nullable = false) })
    private List<Actors> actors;


}

    /*@OneToMany(mappedBy = "movies")
    Set<Favorite>favorites= new HashSet<>();
    @OneToMany(mappedBy = "movies")
    Set<MovieGenre>movieGenres= new HashSet<>();
    @OneToMany(mappedBy = "movies")
    Set<MovieDirector>movieDirectors= new HashSet<>();*/

    /*@OneToMany(mappedBy = "movies")
    Set<MovieAward>movieAwards= new HashSet<>();
    @OneToMany(mappedBy = "movies")
    Set<MovieScreenwritter>movieScreenwritters= new HashSet<>();*/


