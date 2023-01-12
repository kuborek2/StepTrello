package anstar.StepTrello;

import anstar.StepTrello.Entity.Board;
import anstar.StepTrello.enums.Tags;
import anstar.StepTrello.mapper.BoardDtoToBoard;
import anstar.StepTrello.model.BoardDto;
import anstar.StepTrello.model.NoteDto;
import anstar.StepTrello.model.UserDto;
import anstar.StepTrello.repository.BoardRepository;
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
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class BoardTest {


    @InjectMocks
    BusinessLogicImpl businessLogic;

    @Mock
    BoardRepository boardRepository;

    @Mock
    BoardDtoToBoard boardDtoToBoard;



    @Test
    public void canCreateBoard() {

        //given
        String name = "My Board";
        String owner = "Adam";
        ArrayList<NoteDto> notesArrayList = new ArrayList<>();
        ArrayList<UserDto> collaboratorsArrayList = new ArrayList<>();
        Tags tagName = Tags.NONE;

                BoardDto boardDto = new BoardDto(
                name,
                owner,
                        notesArrayList,
                collaboratorsArrayList,
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

//    public BoardTest(BusinessLogic businessLogic) {
//        this.businessLogic = businessLogic;
//    }
//
//    @Tag("Board")
//    @Test
//    void canCreateBoard() {
//
//        //given
//        String name = "My Board";
//        String owner = "Adam";
//        ArrayList<NoteDto> notesArrayList = new ArrayList<>();
//        ArrayList<UserDto> collaboratorsArrayList = new ArrayList<>();
//        Tags tagName = Tags.NONE;
//
//        BoardDto boardDto = new BoardDto(
//                name,
//                owner,
////                collaboratorsArrayList,
//                tagName
//        );
//
//        //when
//        Optional<BoardDto> result = businessLogic.addBoard(boardDto);
//
//        //then
//        assertTrue(result.isPresent());
//        assertTrue(result.get().getName() == name);
//        assertTrue(result.get().getOwnerLogin() == owner);
//        assertTrue(result.get().getTagName() == tagName);
//        assertTrue(result.get().getNotesArrayList().equals(notesArrayList));
//        assertTrue(result.get().getCollaboratorsArrayList().equals(collaboratorsArrayList));
//
//    }
//    First Test Done
//
//    @Test
//    void canDeleteBoard(){
//        String name = "My Board";
//        String owner = "Adam";
//        ArrayList<NoteDto> notesArrayList = new ArrayList<>();
//        ArrayList<UserDto> collaboratorsArrayList = new ArrayList<>();
//        Tags tagName = Tags.NONE;
//
//
//
//        BoardDto boardDto = new BoardDto(
//                name,
//                owner,
////                collaboratorsArrayList,
//                tagName
//        );
//
//
//        //when
//        Optional<BoardDto> newBoard = businessLogic.addBoard(boardDto);
//        Boolean result = businessLogic.deleteBoard(boardDto.getName());
//        //then
//        assertTrue(result);
//
//    }
//
//    @Test
//    void updateBoard() {
//        //given
//        String name = "My Board";
//        String owner = "Adam";
//        ArrayList<NoteDto> notesArrayList = new ArrayList<>();
//        ArrayList<UserDto> collaboratorsArrayList = new ArrayList<>();
//        Tags tagName = Tags.NONE;
//
//        String name2 = "My Board";
//        String owner2 = "Adam";
//        Tags tagName2 = Tags.NONE;
//
//        BoardDto boardDto = new BoardDto(
//                name,
//                owner,
////                collaboratorsArrayList,
//                tagName
//        );
//
//        BoardDto boardDto2 = new BoardDto(
//                name2,
//                owner2,
////                collaboratorsArrayList,
//                tagName2
//        );
//
//        //when
//        Optional<BoardDto> newBoard = businessLogic.addBoard(boardDto2);
//        Optional<BoardDto> result = businessLogic.updateBoard(name ,boardDto);
//
//        //then
//        assertTrue(result.isPresent());
//        assertTrue(result.get().getName() == name);
//        assertTrue(result.get().getOwnerLogin() == owner);
//        assertTrue(result.get().getTagName() == tagName);
//        assertTrue(result.get().getNotesArrayList().equals(notesArrayList));
//        assertTrue(result.get().getCollaboratorsArrayList().equals(collaboratorsArrayList));
//    }
//
//    @Test
//
//    void updateTag() {
//        //given
//
//        String name = "My Board";
//        String owner = "Adam";
//        ArrayList<NoteDto> notesArrayList = new ArrayList<>();
//        ArrayList<UserDto> collaboratorsArrayList = new ArrayList<>();
//        Tags tagName = Tags.NONE;
//        BoardDto boardDto = new BoardDto(
//                name,
//                owner,
////                collaboratorsArrayList,
//                tagName
//        );
//
//        Tags newTag = Tags.GREEN;
//
//
//
//        //when
//        Optional<BoardDto> newBoard = businessLogic.addBoard(boardDto);
//        Boolean result = businessLogic.updateTag(name,newTag );
//
//        Boolean secondResult = businessLogic.updateTag(name,newTag );
//
//        //then
//        assertTrue(result);
//    }

}
