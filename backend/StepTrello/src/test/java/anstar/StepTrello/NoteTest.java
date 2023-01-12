package anstar.StepTrello;

import anstar.StepTrello.model.NoteDto;
import anstar.StepTrello.model.UserDto;
import anstar.StepTrello.service.BusinessLogic;
import anstar.StepTrello.service.impl.BusinessLogicImpl;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NoteTest {
    private final BusinessLogic businessLogic;


    public NoteTest(BusinessLogic businessLogic) {
        this.businessLogic = businessLogic;
    }

    @Tag("Note")
    @ParameterizedTest


    void canCreateNote() {
        //given

        String title = "CoolNote";
        String noteContent = "This is content of this note";
        String boardName = "abc1";
        NoteDto noteDto = new NoteDto(
                title,
                noteContent,
                boardName
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
    void canCreateNonValidNote( String title, String noteContent, String boardName) {

        //given
        NoteDto noteDto = new NoteDto(
                title,
                noteContent,
                boardName
        );

        //when
        Optional<NoteDto> result = businessLogic.addNote(noteDto);

        //then
        assertFalse(result.isPresent());
    }
    @ParameterizedTest
    void canDeleteNote() {

        //given
        String title = "CoolNote";
        String noteContent = "This is content of this note";
        String boardName = "abc1";
        NoteDto noteDto = new NoteDto(
                title,
                noteContent,
                boardName
                );

        //when
        Optional<NoteDto> newNote = businessLogic.addNote(noteDto);
        Boolean result = businessLogic.deleteNote(newNote.get().getNoteId());

        //then
        assertTrue(result);


    }

    @ParameterizedTest
    void noteShouldNotBeDeleted() {
            //given
            String title = "CoolNote";
            String noteContent = "This is content of this note";
            String boardName = "abc1";
            NoteDto noteDto = new NoteDto(
                    title,
                    noteContent,
                    boardName
            );

            //when
            Optional<NoteDto> newNote = businessLogic.addNote(noteDto);
            Boolean result = businessLogic.deleteNote(newNote.get().getNoteId());

            //then
            assertFalse(result);
    }

    @ParameterizedTest
    void canNoteBeUpdated(Integer noteId, String title, String noteContent, String boardName) {

        //given
        NoteDto noteDto = new NoteDto(
                noteId,
                title,
                noteContent,
                boardName
        );
        //when
        Optional<NoteDto> result = businessLogic.updateNote(noteDto);
        //then
        assertTrue(result.isPresent());
        assertTrue(result.get().getNoteId() == noteId);
        assertTrue(result.get().getTitle() == title);
        assertTrue(result.get().getNoteContent() == noteContent);

    }
    @ParameterizedTest
    void canNoteBeNotUpdated(Integer noteId, String title, String noteContent, String boardName) {

        //given
        NoteDto noteDto = new NoteDto(
                noteId,
                title,
                noteContent,
                boardName
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
