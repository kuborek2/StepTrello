package anstar.StepTrello.Entity;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Entity
@Table(name = "board")
public class Board implements Serializable {
//    board_name VARCHAR(30) PRIMARY KEY,
//    owner_login VARCHAR(25),
//    collaborators_list VARCHAR ARRAY,
//    tag_name VARCHAR(6)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Integer boardId;

    @Column(name = "board_name")
    private String boardName;

    @Column(name = "owner_login")
    private String ownerLogin;

    @Column(name = "tag_name")
    private String tagName;

    @Column(name = "description")
    private String description;

    private Board(Board.Builder builder){
        boardId = builder.board_id;
        boardName = builder.board_name;
        ownerLogin = builder.owner_login;
        tagName = builder.tag_name;
        description = builder.description;
    }
    public Board() {}

    public static final class Builder {
        public Integer board_id;
        private String board_name;
        private String owner_login;
        private String tag_name;

        private String description;


        public Builder () {
        }

        public Board.Builder board_id(Integer board_id){
            this.board_id = board_id;
            return this;
        }

        public Board.Builder board_name(String board_name) {
            this.board_name = board_name;
            return this;
        }

        public Board.Builder owner_login(String owner_login) {
            this.owner_login = owner_login;
            return this;
        }

        public Board.Builder tag_name(String tag_name) {
            this.tag_name = tag_name;
            return this;
        }

        public Board.Builder description(String description){
            this.description = description;
            return this;
        }

        public Board build() {
            return new Board(this);
        }

    }

}
