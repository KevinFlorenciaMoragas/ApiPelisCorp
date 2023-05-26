package ApiProyectoM12.DTO;


import ApiProyectoM12.modelo.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import lombok.Data;
import org.springframework.data.relational.core.sql.In;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieDTO {
    @Serial
    private static final long serialVersionUID = 1L;
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
    @Column(name = "banner")
    private String banner;
    @Column(name = "trailer", length = 200)
    private String trailer;
    @Column(name ="photo")
    private String photo;
    private List<Integer> id_poster;
    private List<Integer> id_actors;
    private List<Integer> id_genre;
    private List<Integer> id_director;
    private List<Integer> id_screenwritter;
}