package anstar.StepTrello;

import anstar.StepTrello.model.NoteDto;
import anstar.StepTrello.service.impl.BusinessLogicImpl;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.ArrayList;

public class NoteTest {
    final BusinessLogicImpl businessLogicImpl = new BusinessLogicImpl();

    @Tag("Note")
    @ParameterizedTest


    void canAddBoard() {
    //given
        String name;
        String ownerLogin;
        ArrayList<NoteDto> notesArrayList;
    //when

    //then
    }
}
