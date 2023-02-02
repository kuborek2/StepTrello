package anstar.StepTrello;

import anstar.StepTrello.Entity.Board;
import anstar.StepTrello.Entity.Note;
import anstar.StepTrello.mapper.NoteDtoToNote;
import anstar.StepTrello.mapper.NoteToNoteDto;
import anstar.StepTrello.model.NoteDto;
import anstar.StepTrello.model.UserDto;
import anstar.StepTrello.repository.BoardRepository;
import anstar.StepTrello.repository.NoteRepository;
import anstar.StepTrello.service.BusinessLogic;
import anstar.StepTrello.service.impl.BusinessLogicImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
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

    @Mock
    NoteDtoToNote noteDtoToNote;

//    @Mock
//    NoteToNoteDto noteToNoteDto;

    @BeforeEach
    void init(){
        noteRepository.deleteAll();
    }



    @Tag("Note")
    @Test
    void canCreateNote() {

        //given
        int noteId = 5;
        String title = "CoolNote";
        String noteContent = "This is content of this note";
        Integer boardId = 1;
        NoteDto noteDto = new NoteDto(
                noteId,
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
        assertTrue(result.get().getNoteId() == noteId);


    }

    @ParameterizedTest
    @CsvSource({
            "-1,1,FajnaNotatka, 5",
            "6,,Notatka,",
            "4,FajnaNotatka,tak,-1",
    })
    void canCreateNonValidNote(int noteId, String title, String noteContent, Integer boardId) {

        //given
        NoteDto noteDto = new NoteDto(
                noteId,
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
        int nodeId = 1;
        String title = "CoolNote";
        String noteContent = "This is content of this note";
        Integer boardId = 1;
        NoteDto noteDto = new NoteDto(
                nodeId,
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
            int noteId = 999;
            String title = "Test note for should not delete";
            String noteContent = "This is content of this note";
            Integer boardId = 1;
            NoteDto noteDto = new NoteDto(
                    noteId,
                    title,
                    noteContent,
                    boardId
            );

            //when
            businessLogic.deleteNote(noteDto.getNoteId());
            Optional<Note> deletedNote = noteRepository.findNoteByTitle(noteDto.getTitle());

            //then
            assertTrue(deletedNote.isEmpty());
    }

    @Test
    void canNoteBeUpdated() {

        //given
        int noteId = 1;
        String title = "yes";
        String noteContent = "This is content of this note";
        Integer boardId = 1;
        NoteDto noteDto = new NoteDto(
                noteId,
                title,
                noteContent,
                boardId
        );
        //when
        businessLogic.addNote(noteDto);
        Optional<NoteDto> result = businessLogic.updateNote(noteDto);
        //then
        assertTrue(result.isPresent());
        assertTrue(result.get().getNoteId() == noteId);
        assertTrue(result.get().getTitle() == title);
        assertTrue(result.get().getNoteContent() == noteContent);

    }
    @Test
    void canNoteBeNotUpdated() {

        //given
        int noteId = 127;
        String title = "no";
        String noteContent = "This is content of this note";
        Integer boardId = 1;
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

    }

}
