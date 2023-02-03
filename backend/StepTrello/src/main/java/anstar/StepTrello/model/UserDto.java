package anstar.StepTrello.model;


import anstar.StepTrello.Entity.Role;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class UserDto {
    private String login;
    private String email;
    private String password;
    private ArrayList<Role> role;
}
