package anstar.StepTrello.model;

import lombok.*;
import org.springframework.stereotype.Component;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class NoteDto {

    private int noteId;
    private String title;
    private String noteContent;


    public NoteDto(String title, String noteContent) {
        this.noteId = -1;
        this.title = title;
        this.noteContent = noteContent;
    }


}
