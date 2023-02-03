package anstar.StepTrello.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class RoleDto {
    private int id;
    private String roleName;
}
