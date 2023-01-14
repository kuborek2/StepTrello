package anstar.StepTrello.mapper;

import anstar.StepTrello.Entity.Note;
import anstar.StepTrello.Entity.User;
import anstar.StepTrello.model.NoteDto;
import anstar.StepTrello.model.UserDto;
import org.springframework.stereotype.Component;

@Component
public class NoteDtoToNote implements Converter<Note,NoteDto> {
    @Override
    public Note convert(NoteDto noteDto){
        return new Note.Builder()
                .note_id(noteDto.getNoteId())
                .title(noteDto.getTitle())
                .description(noteDto.getNoteContent())
                .board_id(noteDto.getBoardId())
                .build();
    }
}
