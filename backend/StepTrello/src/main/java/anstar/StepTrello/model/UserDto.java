package anstar.StepTrello.model;


import lombok.*;
import org.springframework.stereotype.Component;




@Getter
@Setter
@NoArgsConstructor
@ToString
@Component
public class UserDto {
    private String login;
    private String email;
    private String password;

    public UserDto(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }
}
