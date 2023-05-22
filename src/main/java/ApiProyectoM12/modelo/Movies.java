package ApiProyectoM12.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import java.util.List;


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
    private Integer releaseDate;
    @Column(name = "plot", length = 8000)
    private String plot;
    @Column(name = "duration")
    private Long duration;
    @Column(name = "income")
    private Long income;
    @Column(name = "score")
    private Double score;
    @JsonManagedReference
    @OneToMany(mappedBy = "id",cascade = CascadeType.MERGE)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Poster> poster;
    @Column(name = "trailer", length = 200)
    private String trailer;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonManagedReference
    @JoinTable(name = "moviesActors",
            joinColumns = { @JoinColumn(name = "id_movies") },
            inverseJoinColumns = { @JoinColumn(name = "id_actors", nullable = false) })
    private List<Actors> actors;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonManagedReference
    @JoinTable(name = "moviesGenres",
            joinColumns = { @JoinColumn(name = "id_movies") },
            inverseJoinColumns = { @JoinColumn(name = "id_genre", nullable = false) })
    private List<Genre> genre;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonManagedReference
    @JoinTable(name = "moviesDirectors",
            joinColumns = { @JoinColumn(name = "id_movies") },
            inverseJoinColumns = { @JoinColumn(name = "id_director", nullable = false) })
    private List<Director> director;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonManagedReference
    @JoinTable(name = "moviesScreenwritters",
            joinColumns = { @JoinColumn(name = "id_movies") },
            inverseJoinColumns = { @JoinColumn(name = "id_screenwritter", nullable = false) })
    private List<Screenwritter> screenwritter;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonManagedReference
    @JoinTable(name = "moviesFavorites",
            joinColumns = { @JoinColumn(name = "id_movies") },
            inverseJoinColumns = { @JoinColumn(name = "id_user", nullable = false) })
    private List<User> favorite;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JsonManagedReference
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JoinTable(name = "moviesAwards",
            joinColumns = { @JoinColumn(name = "id_movies") },
            inverseJoinColumns = { @JoinColumn(name = "id_award", nullable = false) })
    private List<Awards> awards;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonManagedReference
    @JoinTable(name = "moviesReviews",
            joinColumns = { @JoinColumn(name = "id_movies") },
            inverseJoinColumns = { @JoinColumn(name = "id_review", nullable = false) })
    private List<Reviews> movieReviews;

}
