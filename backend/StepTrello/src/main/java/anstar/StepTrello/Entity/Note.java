package anstar.StepTrello.Entity;


import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private Integer noteId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "board_id")
    private Integer boardId;

    private Note(Note.Builder builder){
        noteId = builder.note_id;
        title= builder.title;
        description = builder.description;
        boardId = builder.board_id;
    }
    public Note() {}

    public static final class Builder {

        private  String title;
        public  Integer note_id;
        private  String description;
        private Integer board_id;

        public Builder() {
        }

        public Note.Builder title(String title) {
            this.title = title;
            return this;
        }

        public Note.Builder note_id(Integer note_id) {
            this.note_id = note_id;
            return this;
        }

        public Note.Builder description(String description) {
            this.description = description;
            return this;
        }

        public Note.Builder board_id(Integer board_id) {
            this.board_id = board_id;
            return this;
        }


        public Note build() {
            return new Note(this);
        }
    }
}
