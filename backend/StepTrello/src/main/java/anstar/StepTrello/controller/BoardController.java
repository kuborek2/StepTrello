package anstar.StepTrello.controller;


import anstar.StepTrello.enums.Tags;
import anstar.StepTrello.model.BoardDto;
import anstar.StepTrello.service.impl.BusinessLogicImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class BoardController {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(BoardController.class);
//    private static final Logger LOGGER1 = LoggerFactory.getLogger(BoardController.class);

    private final BusinessLogicImpl businessLogic;

    @Autowired
    public BoardController(BusinessLogicImpl businessLogic) {
        this.businessLogic = businessLogic;
    }

    // Add new board
    @CrossOrigin
    @PutMapping(value = "/board")
    public ResponseEntity<Optional<BoardDto>> addBoard(@RequestBody BoardDto boardDto) {
        LOGGER.info("Add board " + boardDto.getName() );

        businessLogic.addBoard(boardDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Delete board
    @CrossOrigin
    @DeleteMapping(value = "/board/{boardName}")
    public ResponseEntity<Boolean> deleteBoard(@RequestBody BoardDto boardDto) {
        LOGGER.info("Delete this board " + boardDto.getName() );
        businessLogic.deleteBoard(boardDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Get all boards
    @CrossOrigin
    @GetMapping(value = "/board")
    public ResponseEntity<ArrayList<BoardDto>> getBoards() {
        LOGGER.info("find all boards ");

        ArrayList<BoardDto> boardsDto = businessLogic.getBoards();
        return new ResponseEntity<>(boardsDto, HttpStatus.OK);
    }

    //Update board
    @CrossOrigin
    @PutMapping(value = "/board/{boardName}")
    public ResponseEntity<Optional<BoardDto>> updateBoard(@RequestBody BoardDto boardDto, @RequestParam String boardName) {
        LOGGER.info("Update this board " + boardName );

        businessLogic.updateBoard(boardName,boardDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping(value = "/board/notes/{boardName}")
    public ResponseEntity<Optional<BoardDto>> updateBoardNotes(@RequestBody BoardDto boardDto, @RequestParam String boardName) {
        LOGGER.info("Update this board " + boardDto.getName() + " and this note " + boardName);


        businessLogic.updateBoard(boardName,boardDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping(value = "/board/tag/{boardName}")
    public ResponseEntity <Optional<BoardDto>> updateBoardTag(@RequestBody Tags tag, @RequestParam String boardName) {
        LOGGER.info("Update this board " + boardName + " with this tag " + tag);

        businessLogic.updateTag(boardName , tag );

        return null;
    }

}
