package anstar.StepTrello.repository;

import anstar.StepTrello.Entity.Board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends JpaRepository<Board, String>, CrudRepository<Board,String> {


}
