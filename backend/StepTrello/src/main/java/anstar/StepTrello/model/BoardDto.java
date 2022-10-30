package anstar.StepTrello.model;

import anstar.StepTrello.enums.Tags;

import java.util.ArrayList;

public class BoardDto {
    private String name;
    private String ownerLogin;
    private ArrayList<NoteDto> notesArrayList;
    private ArrayList<UserDto> collaboratorsArrayList;

    public BoardDto(String name, String ownerLogin, ArrayList<NoteDto> notesArrayList, ArrayList<UserDto> collaboratorsArrayList) {
        this.name = name;
        this.ownerLogin = ownerLogin;
        this.notesArrayList = notesArrayList;
        this.collaboratorsArrayList = collaboratorsArrayList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerLogin() {
        return ownerLogin;
    }

    public void setOwnerLogin(String ownerLogin) {
        this.ownerLogin = ownerLogin;
    }

    public ArrayList<NoteDto> getNotesArrayList() {
        return notesArrayList;
    }

    public void setNotesArrayList(ArrayList<NoteDto> notesArrayList) {
        this.notesArrayList = notesArrayList;
    }

    public ArrayList<UserDto> getCollaboratorsArrayList() {
        return collaboratorsArrayList;
    }

    public void setCollaboratorsArrayList(ArrayList<UserDto> collaboratorsArrayList) {
        this.collaboratorsArrayList = collaboratorsArrayList;
    }
}
