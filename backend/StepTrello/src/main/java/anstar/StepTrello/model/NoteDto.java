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

    private Integer noteId;
    private String title;
    private String noteContent;
    private Integer boardId;


    public NoteDto(String title, String noteContent, Integer boardId) {

        this.title = title;
        this.noteContent = noteContent;
        this.boardId = boardId;
    }


}
