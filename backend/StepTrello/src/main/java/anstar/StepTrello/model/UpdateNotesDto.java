package anstar.StepTrello.model;

import anstar.StepTrello.Entity.Note;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class UpdateNotesDto {

    private String action;
    private Note note;
}
