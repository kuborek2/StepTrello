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
    private String boardName;


    public NoteDto(String title, String noteContent, String boardName) {
        this.noteId = -1;
        this.title = title;
        this.noteContent = noteContent;
        this.boardName = boardName;
    }


}
