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
    private String name;
    private String ownerLogin;
    private ArrayList<NoteDto> notesArrayList;
    private ArrayList<UserDto> collaboratorsArrayList;
    private Tags tagName;

    public BoardDto(String name, String ownerLogin,  Tags tagName) {
        this.name = name;
        this.ownerLogin = ownerLogin;

        this.tagName = tagName;
    }


}
