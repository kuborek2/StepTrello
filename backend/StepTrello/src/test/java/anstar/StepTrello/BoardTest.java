package anstar.StepTrello;

import anstar.StepTrello.enums.Tags;
import anstar.StepTrello.model.BoardDto;
import anstar.StepTrello.model.NoteDto;
import anstar.StepTrello.model.UserDto;
import anstar.StepTrello.service.BusinessLogic;
import anstar.StepTrello.service.impl.BusinessLogicImpl;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTest {
    private final BusinessLogic businessLogic;


    public BoardTest(BusinessLogic businessLogic) {
        this.businessLogic = businessLogic;
    }

    @Tag("Board")
    @ParameterizedTest
    void canCreateBoard() {

        //given
        String name = "My Board";
        String owner = "Adam";
        ArrayList<NoteDto> notesArrayList = new ArrayList<>();
        ArrayList<UserDto> collaboratorsArrayList = new ArrayList<>();
        Tags tagName = Tags.NONE;

        BoardDto boardDto = new BoardDto(
                name,
                owner,
//                collaboratorsArrayList,
                tagName
        );

        //when
        Optional<BoardDto> result = businessLogic.addBoard(boardDto);

        //then
        assertTrue(result.isPresent());
        assertTrue(result.get().getName() == name);
        assertTrue(result.get().getOwnerLogin() == owner);
        assertTrue(result.get().getTagName() == tagName);
        assertTrue(result.get().getNotesArrayList().equals(notesArrayList));
        assertTrue(result.get().getCollaboratorsArrayList().equals(collaboratorsArrayList));

    }

    @ParameterizedTest
    void canDeleteBoard(){
        String name = "My Board";
        String owner = "Adam";
        ArrayList<NoteDto> notesArrayList = new ArrayList<>();
        ArrayList<UserDto> collaboratorsArrayList = new ArrayList<>();
        Tags tagName = Tags.NONE;



        BoardDto boardDto = new BoardDto(
                name,
                owner,
//                collaboratorsArrayList,
                tagName
        );


        //when
        Optional<BoardDto> newBoard = businessLogic.addBoard(boardDto);
        Boolean result = businessLogic.deleteBoard(boardDto);
        //then
        assertTrue(result);

    }

    @ParameterizedTest
    void updateBoard() {
        //given
        String name = "My Board";
        String owner = "Adam";
        ArrayList<NoteDto> notesArrayList = new ArrayList<>();
        ArrayList<UserDto> collaboratorsArrayList = new ArrayList<>();
        Tags tagName = Tags.NONE;

        String name2 = "My Board";
        String owner2 = "Adam";
        Tags tagName2 = Tags.NONE;

        BoardDto boardDto = new BoardDto(
                name,
                owner,
//                collaboratorsArrayList,
                tagName
        );

        BoardDto boardDto2 = new BoardDto(
                name2,
                owner2,
//                collaboratorsArrayList,
                tagName2
        );

        //when
        Optional<BoardDto> newBoard = businessLogic.addBoard(boardDto2);
        Optional<BoardDto> result = businessLogic.updateBoard(name ,boardDto);

        //then
        assertTrue(result.isPresent());
        assertTrue(result.get().getName() == name);
        assertTrue(result.get().getOwnerLogin() == owner);
        assertTrue(result.get().getTagName() == tagName);
        assertTrue(result.get().getNotesArrayList().equals(notesArrayList));
        assertTrue(result.get().getCollaboratorsArrayList().equals(collaboratorsArrayList));
    }

    @ParameterizedTest

    void updateTag() {
        //given
        // Napisz dane do boarda, potem zrób boarda, wywołaj update tag z nowym tagiem, i potem drugie funkcje z tagami co nie istnieją git st
        String name = "My Board";
        String owner = "Adam";
        ArrayList<NoteDto> notesArrayList = new ArrayList<>();
        ArrayList<UserDto> collaboratorsArrayList = new ArrayList<>();
        Tags tagName = Tags.NONE;
        BoardDto boardDto = new BoardDto(
                name,
                owner,
//                collaboratorsArrayList,
                tagName
        );

        Tags newTag = Tags.GREEN;

        // Za chuj nie wiem jak dac wartosc pusta enumowi wiec zostawie tak bez niczego xD

        //when
        Optional<BoardDto> newBoard = businessLogic.addBoard(boardDto);
        Boolean result = businessLogic.updateTag(name,newTag );

        Boolean secondResult = businessLogic.updateTag(name,newTag );

        //then
        assertTrue(result);
    }

}
