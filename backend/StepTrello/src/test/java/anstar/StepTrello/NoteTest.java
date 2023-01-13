package anstar.StepTrello;

import anstar.StepTrello.Entity.Board;
import anstar.StepTrello.Entity.Note;
import anstar.StepTrello.model.NoteDto;
import anstar.StepTrello.model.UserDto;
import anstar.StepTrello.repository.BoardRepository;
import anstar.StepTrello.repository.NoteRepository;
import anstar.StepTrello.service.BusinessLogic;
import anstar.StepTrello.service.impl.BusinessLogicImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class NoteTest {


    @InjectMocks
    BusinessLogicImpl businessLogic;

    @Mock
    NoteRepository noteRepository;



    @Tag("Note")
    @Test


    void canCreateNote() {
        //given

        String title = "CoolNote";
        String noteContent = "This is content of this note";
        Integer boardId = 1;
        NoteDto noteDto = new NoteDto(
                title,
                noteContent,
                boardId
        );

        //when
        Optional<NoteDto> result = businessLogic.addNote(noteDto);

        //then
        assertTrue(result.isPresent());
        assertTrue(result.get().getTitle() == title);
        assertTrue(result.get().getNoteContent() == noteContent);
        assertTrue(result.get().getNoteId() != -1);


    }

    @ParameterizedTest
    @CsvSource({
            "1,FajnaNotatka, Notatka",
            ", Notatka",
            "FajnaNotatka, ",
            " , , ",
            ",,",

    })
    void canCreateNonValidNote( String title, String noteContent, Integer boardId) {

        //given
        NoteDto noteDto = new NoteDto(
                title,
                noteContent,
                boardId
        );

        //when
        Optional<NoteDto> result = businessLogic.addNote(noteDto);

        //then
        assertFalse(result.isPresent());
    }
    @Test
    void canDeleteNote() {

        //given
        String title = "CoolNote";
        String noteContent = "This is content of this note";
        Integer boardId = 1;
        NoteDto noteDto = new NoteDto(
                title,
                noteContent,
                boardId
        );

        //when
        Optional<NoteDto> newNote = businessLogic.addNote(noteDto);
        businessLogic.deleteNote(newNote.get().getNoteId());
        Optional<Note> deletedNote = noteRepository.findNoteByTitle(noteDto.getTitle());

        //then
        assertTrue(deletedNote.isEmpty());


    }

    @Test
    void noteShouldNotBeDeleted() {
            //given
            String title = "CoolNote";
            String noteContent = "This is content of this note";
            Integer boardId = 1;
            NoteDto noteDto = new NoteDto(
                    title,
                    noteContent,
                    boardId
            );

            //when
            Optional<NoteDto> newNote = businessLogic.addNote(noteDto);
            businessLogic.deleteNote(newNote.get().getNoteId());
            Optional<Note> deletedNote = noteRepository.findNoteByTitle(noteDto.getTitle());

            //then
            assertFalse(deletedNote.isEmpty());
    }

    @Test
    void canNoteBeUpdated(Integer noteId, String title, String noteContent, Integer boardId) {

        //given
        NoteDto noteDto = new NoteDto(
                noteId,
                title,
                noteContent,
                boardId
        );
        //when
        Optional<NoteDto> result = businessLogic.updateNote(noteDto);
        //then
        assertTrue(result.isPresent());
        assertTrue(result.get().getNoteId() == noteId);
        assertTrue(result.get().getTitle() == title);
        assertTrue(result.get().getNoteContent() == noteContent);

    }
    @Test
    void canNoteBeNotUpdated(Integer noteId, String title, String noteContent, Integer boardId) {

        //given
        NoteDto noteDto = new NoteDto(
                noteId,
                title,
                noteContent,
                boardId
        );
        //when
        Optional<NoteDto> result = businessLogic.updateNote(noteDto);
        //then
        assertFalse(result.isPresent());
        assertFalse(result.get().getNoteId() == noteId);
        assertFalse(result.get().getTitle() == title);
        assertFalse(result.get().getNoteContent() == noteContent);

    }

}
