package ApiProyectoM12.dto;

import ApiProyectoM12.modelo.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private String id;
    private String username, name, last_name, email;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime createdAt;
    public static UserResponse fromUser(User user){
        return UserResponse.builder()
                .id(user.getId().toString())
                .username(user.getUsername())
                .name(user.getName())
                .last_name(user.getLast_name())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .build();
    }

}
