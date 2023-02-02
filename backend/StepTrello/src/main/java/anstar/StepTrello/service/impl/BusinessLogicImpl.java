package anstar.StepTrello.service.impl;

import anstar.StepTrello.Entity.Board;
import anstar.StepTrello.Entity.Note;
import anstar.StepTrello.Entity.Role;
import anstar.StepTrello.Entity.User;
import anstar.StepTrello.mapper.Converter;
import anstar.StepTrello.model.BoardDto;
import anstar.StepTrello.model.NoteDto;
import anstar.StepTrello.model.UserDto;

import anstar.StepTrello.repository.BoardRepository;
import anstar.StepTrello.repository.NoteRepository;
import anstar.StepTrello.repository.RoleRepository;
import anstar.StepTrello.repository.UserRepository;
import anstar.StepTrello.service.BusinessLogic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BusinessLogicImpl implements BusinessLogic, UserDetailsService {

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
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;



    public BusinessLogicImpl(UserRepository userRepository,
                             BoardRepository boardRepository,
                             NoteRepository noteRepository, Converter<List<UserDto>, List<User>> userListMapper,
                             Converter<User, UserDto> userDtoToUser,
                             Converter<UserDto, User> userToUserDto,
                             Converter<ArrayList<BoardDto>, ArrayList<Board>> boardToBoardDto,
                             Converter<Board, BoardDto> boardDtoToBoard,
                             Converter<NoteDto, Note> noteToNoteDto, Converter<Note, NoteDto> noteDtoToNote,
                             Converter<ArrayList<NoteDto>, ArrayList<Note>> notesToNoteDto, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
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
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);

        if (user == null) {
            log.error("User not found in database");
            throw new UsernameNotFoundException("User not found in database");
        }else {
            log.info("User found in the database: {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    // User
    @Override
    public Optional<User> saveUser(UserDto userDto) {

        System.out.println(userDto);
        Optional<User> userOptional = Optional.ofNullable(userRepository.findUserByUsername(userDto.getLogin()));
        if(userOptional.isPresent()){
            throw new IllegalStateException("Login taken");
        }
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));


        return  Optional.ofNullable(userRepository.save(userDtoToUser.convert(userDto)));
    }


    @Override
    public Optional<UserDto> getUser(String login) {
        log.info(login);
        return Optional.ofNullable(userToUserDto.convert(userRepository.findUserByUsername(login)));

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
    public void deleteBoard(int id) {
        boardRepository.deleteBoardByBoardId(id);
    }

    @Override
    public ArrayList<BoardDto> getBoards() {

    ArrayList <Board> boards = (ArrayList<Board>) boardRepository.findAll();
    return boardToBoardDto.convert(boards);
    }

    @Override
    public Optional<BoardDto> updateBoard(Integer boardId , BoardDto boardDto) {
//        Board board = boardRepository.findBoardByBoardId(boardId);
//
//        if(board != null){

        Board boardBuilder = new Board.Builder()
                .board_id(boardId)
                .board_name(boardDto.getName())
                .owner_login(boardDto.getOwnerLogin())
                .tag_name(boardDto.getTagName())
                .description(boardDto.getDescription())
                .build();

        boardRepository.save(boardBuilder);

//        }
        return Optional.ofNullable(boardDto);
    }

    // Notes
    @Override
    public Optional<NoteDto> addNote(NoteDto noteDto) {
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
        Optional<Note> note = Optional.ofNullable(noteRepository.findNoteByNoteId(noteDto.getNoteId()));
        if(note.isPresent()){
            Note noteBuilder = new Note.Builder()
                    .note_id(noteDto.getNoteId())
                    .title(noteDto.getTitle())
                    .description(noteDto.getNoteContent())
                    .board_id(noteDto.getBoardId())
                    .build();
            noteRepository.save(noteBuilder);
            return Optional.ofNullable(noteDto);
        }
        return Optional.empty();
    }

    // Tag
    @Override
    public Boolean updateTag( Integer boardId , String tag ) {
        Board board = boardRepository.findBoardByBoardId(boardId);

        if(board != null){
            Board boardBuilder = new Board.Builder()
                    .board_id(board.getBoardId())
                    .board_name(board.getBoardName())
                    .owner_login(board.getOwnerLogin())
                    .tag_name(tag)
                    .build();

            boardRepository.save(boardBuilder);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public ArrayList<BoardDto> getBoardsByUserName(String userName) {
        ArrayList<Board> boardArrayList = boardRepository.findBoardByOwnerLogin(userName);
        return boardToBoardDto.convert(boardArrayList);
    }

    @Override
    public Role saveRole(Role role){
        log.info("Saving role to database");
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser (String login, String roleName){
        log.info("Finding user by name");
        User user = userRepository.findUserByUsername(login);
        log.info("Finding role by name");
        Role role = roleRepository.findByName(roleName);
        log.info("Adding role to user ");
        user.getRoles().add(role);
        log.info("Updating user role;");
        userRepository.save(user);

    }


}
