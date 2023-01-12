package anstar.StepTrello.mapper;

import anstar.StepTrello.Entity.Board;
import anstar.StepTrello.Entity.User;
import anstar.StepTrello.enums.Tags;
import anstar.StepTrello.model.BoardDto;
import anstar.StepTrello.model.UserDto;
import org.springframework.stereotype.Component;

@Component
public class BoardDtoToBoard implements Converter<Board, BoardDto>{


    @Override
    public Board convert(BoardDto boardDto) {
        return new Board.Builder()
                .board_name(boardDto.getName())
                .owner_login(boardDto.getOwnerLogin())
                .tag_name(String.valueOf(boardDto.getTagName()))
                .build();
    }
}
