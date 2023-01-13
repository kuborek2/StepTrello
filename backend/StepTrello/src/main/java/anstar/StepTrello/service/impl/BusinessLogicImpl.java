package anstar.StepTrello.service.impl;

import anstar.StepTrello.Entity.Board;
import anstar.StepTrello.Entity.Note;
import anstar.StepTrello.Entity.User;
import anstar.StepTrello.enums.Tags;
import anstar.StepTrello.mapper.Converter;
import anstar.StepTrello.model.BoardDto;
import anstar.StepTrello.model.NoteDto;
import anstar.StepTrello.model.UserDto;

import anstar.StepTrello.repository.BoardRepository;
import anstar.StepTrello.repository.NoteRepository;
import anstar.StepTrello.repository.UserRepository;
import anstar.StepTrello.service.BusinessLogic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BusinessLogicImpl implements BusinessLogic {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final NoteRepository noteRepository;
    private final Converter<List<UserDto>, List<User>> userListMapper;
    private final Converter<User, UserDto> userDtoToUser;
    private final Converter<UserDto, User> userToUserDto;
    private final Converter<ArrayList<BoardDto>,ArrayList<Board>> boardToBoardDto;
    private final Converter<Board,BoardDto> boardDtoToBoard;
    private final Converter<NoteDto,Note> noteToNoteDto;
    private final Converter<Note,NoteDto> noteDtoToNote;
    private final Converter<ArrayList<NoteDto>, ArrayList<Note>> notesToNoteDto;



    public BusinessLogicImpl(UserRepository userRepository,
                             BoardRepository boardRepository,
                             NoteRepository noteRepository, Converter<List<UserDto>, List<User>> userListMapper,
                             Converter<User, UserDto> userDtoToUser,
                             Converter<UserDto, User> userToUserDto,
                             Converter<ArrayList<BoardDto>, ArrayList<Board>> boardToBoardDto,
                             Converter<Board, BoardDto> boardDtoToBoard,
                             Converter<NoteDto, Note> noteToNoteDto, Converter<Note, NoteDto> noteDtoToNote,
                             Converter<ArrayList<NoteDto>, ArrayList<Note>> notesToNoteDto) {
        this.userRepository = userRepository;
        this.boardRepository = boardRepository;
        this.noteRepository = noteRepository;
        this.userListMapper = userListMapper;
        this.userDtoToUser = userDtoToUser;
        this.userToUserDto = userToUserDto;
        this.boardToBoardDto = boardToBoardDto;
        this.boardDtoToBoard = boardDtoToBoard;
        this.noteToNoteDto = noteToNoteDto;
        this.noteDtoToNote = noteDtoToNote;
        this.notesToNoteDto = notesToNoteDto;
    }

    // User
    @Override
    public Optional<UserDto> saveUser(UserDto userDto) {
        System.out.println(userDto);
        Optional<User> userOptional = userRepository.findUserByUsername(userDto.getLogin());
        if(userOptional.isPresent()){
            throw new IllegalStateException("Login taken");
        }

        userRepository.save(userDtoToUser.convert(userDto));

        return  Optional.ofNullable(userDto);
    }

    @Override
    public Optional<UserDto> getUser(String login) {
        Optional <UserDto> userDto = Optional.ofNullable(userToUserDto.convert(userRepository.findUserByLogin(login)));
        //  List<User> user = userRepository.findAll();
        return userDto;

    }

    public List <UserDto> getAllUsers() {

        List<User> users = userRepository.findAll();
        System.out.println(userListMapper.convert(users));
        return userListMapper.convert(users) ;

    }

    @Override
    public void deleteUser(String login) {

        userRepository.deleteUserByUsername(login);

    }

    // Boards
    @Override
    public Optional<BoardDto> addBoard(BoardDto boardDto) {

        System.out.println(boardDto);
        Optional<Board> boardOptional = boardRepository.findBoardByBoardName(boardDto.getName());
        if(boardOptional.isPresent()){
            throw new IllegalStateException("Name of board taken");
        }

        boardRepository.save(boardDtoToBoard.convert(boardDto));


        return  Optional.ofNullable(boardDto);


    }

    @Override
    public void deleteBoard(String boardName) {


        boardRepository.deleteBoardByName(boardName);

    }

    @Override
    public ArrayList<BoardDto> getBoards() {

    ArrayList <Board> boards = (ArrayList<Board>) boardRepository.findAll();
    return boardToBoardDto.convert(boards);
    }

    @Override
    public Optional<BoardDto> updateBoard(String boardName , BoardDto boardDto) {
        Board board = boardRepository.findOneByBoardName(boardName);

        if(board != null){
            Board boardBuilder = new Board.Builder()
                    .board_name(boardName)
                    .owner_login(boardDto.getOwnerLogin())
                    .tag_name(String.valueOf(boardDto.getTagName()))
                    .build();

            boardRepository.save(boardBuilder);
        }
        return Optional.ofNullable(boardDto);
    }

    //Dodaj liste notatek

    // Notes
    @Override
    public Optional<NoteDto> addNote(NoteDto noteDto) {

        System.out.println(noteDto);

        noteRepository.save(noteDtoToNote.convert(noteDto));

        return  Optional.ofNullable(noteDto);
    }

    @Override
    public void deleteNote(int noteId) {

        noteRepository.deleteNoteByNoteId(noteId);
    }

    @Override
    public ArrayList<NoteDto> getNotes() {

        ArrayList<Note> notes = (ArrayList<Note>) noteRepository.findAll();
        return notesToNoteDto.convert(notes);

    }

    @Override
    public Optional<NoteDto> updateNote(NoteDto noteDto) {
        return null;
    }

    // Tag
    @Override
    public Boolean updateTag(String boardName , Tags tag ) {
        return null;
    }

}
