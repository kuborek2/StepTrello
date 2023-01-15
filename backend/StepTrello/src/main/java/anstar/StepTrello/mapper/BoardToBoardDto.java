package anstar.StepTrello.mapper;

import anstar.StepTrello.Entity.Board;
import anstar.StepTrello.Entity.User;
import anstar.StepTrello.enums.Tags;
import anstar.StepTrello.model.BoardDto;
import anstar.StepTrello.model.UserDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BoardToBoardDto implements Converter<ArrayList<BoardDto>, ArrayList<Board>> {

    @Override
    public ArrayList<BoardDto> convert(ArrayList<Board> boards) {
        return boards.stream()
                .map(board -> new BoardDto(
                        board.getBoardId(),
                        board.getBoardName(),
                        board.getOwnerLogin(),
                        null,
                        board.getTagName(),
                        board.getDescription()
                    )).collect(Collectors
                    .toCollection(ArrayList::new));
    }
}



