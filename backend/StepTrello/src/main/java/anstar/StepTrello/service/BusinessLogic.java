package anstar.StepTrello.service;

import anstar.StepTrello.enums.Tags;
import anstar.StepTrello.model.BoardDto;
import anstar.StepTrello.model.NoteDto;
import anstar.StepTrello.model.UserDto;

import java.util.ArrayList;
import java.util.Optional;

public interface BusinessLogic {

    public Optional<UserDto> saveUser(UserDto userDto);

    public Optional<UserDto> deleteUser(UserDto userDto);

    public Optional<BoardDto> addBoard(BoardDto boardDto);

    public BoardDto deleteBoard(BoardDto boardDto);

    public ArrayList<BoardDto> getBoards();

    public BoardDto updateBoard(BoardDto boardDto);

    public NoteDto addNote(NoteDto noteDto);

    public NoteDto deleteNote(NoteDto noteDto);

    public ArrayList<NoteDto> getNotes();

    public NoteDto updateNote(NoteDto noteDto);

    public Boolean addTag(String noteName, Tags tag);

    public Boolean deleteTag(String noteName, Tags tag);


}
