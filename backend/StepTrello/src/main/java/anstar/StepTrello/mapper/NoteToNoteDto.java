package anstar.StepTrello.mapper;

import anstar.StepTrello.Entity.Board;
import anstar.StepTrello.Entity.Note;
import anstar.StepTrello.Entity.User;
import anstar.StepTrello.enums.Tags;
import anstar.StepTrello.model.BoardDto;
import anstar.StepTrello.model.NoteDto;
import anstar.StepTrello.model.UserDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class NoteToNoteDto implements Converter<NoteDto, Note>{
    @Override
    public NoteDto convert(Note note) {
        return new NoteDto(note.getNoteId(),note.getTitle(),note.getDescription(),note.getBoardId());
    }
}



