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

    public Boolean deleteBoard(BoardDto boardDto);

    public ArrayList<BoardDto> getBoards();

    public Optional<BoardDto> updateBoard( String boardName , BoardDto boardDto);

    public Optional<NoteDto> addNote(NoteDto noteDto);

    public Boolean deleteNote(int noteId);

    public ArrayList<NoteDto> getNotes();

    public Optional<NoteDto> updateNote(NoteDto noteDto);

    public Boolean updateTag(String boardName , Tags tag);


}
