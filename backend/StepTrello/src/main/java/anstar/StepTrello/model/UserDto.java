package anstar.StepTrello.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;



@Getter
@Setter
@AllArgsConstructor
@ToString
@Component
public class UserDto {
    private String login;
    private String email;
    private String password;
}
