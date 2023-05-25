package ApiProyectoM12.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReviewDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String text;
    private double averageRating;
    @Column(name = "movie_id")
    private Integer id_movie = 0;
    @Column(name = "user_id")
    private Integer id_user = 0;

}
