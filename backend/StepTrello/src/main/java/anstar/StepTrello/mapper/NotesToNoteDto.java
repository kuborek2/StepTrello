package anstar.StepTrello.mapper;

import anstar.StepTrello.Entity.Board;
import anstar.StepTrello.Entity.Note;
import anstar.StepTrello.enums.Tags;
import anstar.StepTrello.model.BoardDto;
import anstar.StepTrello.model.NoteDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class NotesToNoteDto implements Converter<ArrayList<NoteDto>, ArrayList<Note>> {

    @Override
    public ArrayList<NoteDto> convert(ArrayList<Note> notes){
        return notes.stream()
                .map(note -> new NoteDto(note.getTitle(),note.getDescription(),note.getBoardId())).collect(Collectors.toCollection(ArrayList::new));
    }
}


