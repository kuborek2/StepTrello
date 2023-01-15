package anstar.StepTrello.controller;


import anstar.StepTrello.Entity.Note;
import anstar.StepTrello.enums.Tags;
import anstar.StepTrello.model.BoardDto;
import anstar.StepTrello.model.NoteDto;
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
    @PostMapping(value = "/board")
    public ResponseEntity<Optional<BoardDto>> addBoard(@RequestBody BoardDto boardDto) {
        LOGGER.info("Add board " + boardDto.getName() );

        businessLogic.addBoard(boardDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Delete board
    @CrossOrigin
    @DeleteMapping(value = "/board/{boardName}")
    public ResponseEntity<Boolean> deleteBoard(@PathVariable String boardName) {
        LOGGER.info("Delete this board " + boardName );
        businessLogic.deleteBoard(boardName);

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
    @PutMapping(value = "/board/{boardId}")
    public ResponseEntity<Optional<BoardDto>> updateBoard(@RequestBody BoardDto boardDto, @PathVariable Integer boardId) {
        LOGGER.info("Update this board " + boardId );

        businessLogic.updateBoard(boardId,boardDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @CrossOrigin
//    @PutMapping(value = "/board/notes/{boardName}")
//    public ResponseEntity<Optional<BoardDto>> updateBoardNotes(@RequestBody BoardDto boardDto, @RequestParam String boardName) {
//        LOGGER.info("Update this board " + boardDto.getName() + " and this note " + boardName);
//
//
//        businessLogic.updateBoard(boardName,boardDto);
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @CrossOrigin
    @PutMapping(value = "/board/tag/{boardId}")
    public ResponseEntity <Optional<BoardDto>> updateBoardTag(@RequestParam String tag, @PathVariable Integer boardId) {
        LOGGER.info("Update this board " + boardId + " with this tag " + tag);

        businessLogic.updateTag(boardId , tag );

        return null;
    }

    @CrossOrigin
    @PostMapping(value = "/board/note/")
    public ResponseEntity<Optional<Note>> addNote(@RequestBody NoteDto noteDto) {
        LOGGER.info("Add board " + noteDto.getTitle() );

        businessLogic.addNote(noteDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @CrossOrigin
    @DeleteMapping(value = "/board/note/{noteId}")
    public ResponseEntity<Void> deleteNote(@PathVariable Integer noteId) {
        LOGGER.info("Delete this note " + noteId );
        businessLogic.deleteNote(noteId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/board/notes")
    public ResponseEntity<ArrayList<NoteDto>> getNotes() {
        LOGGER.info("find all boards ");

        ArrayList<NoteDto> notesDto = businessLogic.getNotes();
        return new ResponseEntity<>(notesDto, HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping(value = "/board/note/")
    public ResponseEntity<Optional<NoteDto>> updateNote(@RequestBody NoteDto noteDto) {
        LOGGER.info("Update this board " + noteDto.getTitle());

        businessLogic.updateNote(noteDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
