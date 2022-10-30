package anstar.StepTrello.service.impl;

import anstar.StepTrello.enums.Tags;
import anstar.StepTrello.model.BoardDto;
import anstar.StepTrello.model.NoteDto;
import anstar.StepTrello.model.UserDto;
import anstar.StepTrello.repository.UserRepository;
import anstar.StepTrello.service.BusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;

public class BusinessLogicImpl implements BusinessLogic {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<UserDto> saveUser(UserDto userDto) {

        return null;
    }

    @Override
    public Optional<UserDto> deleteUser(UserDto userDto) {
        return null;
    }

    @Override
    public Optional<BoardDto> addBoard(BoardDto boardDto) {
        return null;
    }

    @Override
    public BoardDto deleteBoard(BoardDto boardDto) {
        return null;
    }

    @Override
    public ArrayList<BoardDto> getBoards() {
        return null;
    }

    @Override
    public BoardDto updateBoard(BoardDto boardDto) {
        return null;
    }

    @Override
    public NoteDto addNote(NoteDto noteDto) {
        return null;
    }

    @Override
    public NoteDto deleteNote(NoteDto noteDto) {
        return null;
    }

    @Override
    public ArrayList<NoteDto> getNotes() {
        return null;
    }

    @Override
    public NoteDto updateNote(NoteDto noteDto) {
        return null;
    }

    @Override
    public Boolean addTag(String noteName, Tags tag) {
        return null;
    }

    @Override
    public Boolean deleteTag(String noteName, Tags tag) {
        return null;
    }
}
