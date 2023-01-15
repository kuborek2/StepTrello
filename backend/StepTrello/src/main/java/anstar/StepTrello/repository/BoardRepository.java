package anstar.StepTrello.repository;

import anstar.StepTrello.Entity.Board;

import anstar.StepTrello.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Repository
@Transactional
public interface BoardRepository extends JpaRepository<Board, String>, CrudRepository<Board,String> {

    @Modifying
    @Query(value = "DELETE FROM Board br where br.boardName = :boardName")
    void deleteBoardByName(@Param("boardName") String boardName);

    @Query(value = "SELECT boardName FROM Board where boardName like :boardname")
    Optional<Board> findBoardByBoardName(@Param("boardname" ) String boardname );

    Board findBoardByBoardId(Integer boardId);

    ArrayList<Board> findBoardByOwnerLogin(String ownerLogin);

    void deleteBoardByBoardId(int BoardId);

}
