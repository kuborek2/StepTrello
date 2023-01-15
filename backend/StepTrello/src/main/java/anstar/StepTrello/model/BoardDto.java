package anstar.StepTrello.model;

import anstar.StepTrello.enums.Tags;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class BoardDto {
    private int board_id;
    private String name;
    private String ownerLogin;
    private ArrayList<UserDto> collaboratorsArrayList;
    private String tagName;
    private String description;
}
