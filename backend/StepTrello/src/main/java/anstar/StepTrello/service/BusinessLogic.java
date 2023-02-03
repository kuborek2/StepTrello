package anstar.StepTrello.service;

import anstar.StepTrello.Entity.Role;
import anstar.StepTrello.Entity.User;
import anstar.StepTrello.model.BoardDto;
import anstar.StepTrello.model.NoteDto;
import anstar.StepTrello.model.UserDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface BusinessLogic {

    // public Optional<UserDto> saveUser(UserDto userDto);

    public Optional<User> saveUser(UserDto userDto);

    public Optional<UserDto> getUser(String login);

    public List <UserDto> getAllUsers() ;

    public void deleteUser(String login);

    public Optional<BoardDto> addBoard(BoardDto boardDto);

    public void deleteBoard(int id);

    public ArrayList<BoardDto> getBoards();

    public Optional<BoardDto> updateBoard(Integer boardId , BoardDto boardDto);

    public Optional<NoteDto> addNote(NoteDto noteDto);

    public void deleteNote(int noteId);

    public ArrayList<NoteDto> getNotes();

    public Optional<NoteDto> updateNote(NoteDto noteDto);

    public Boolean updateTag(Integer boardId , String tag);

    public ArrayList<BoardDto> getBoardsByUserName(String userName);

    public Role saveRole(Role role);

    public User addRoleToUser (String login, String roleName);


}
