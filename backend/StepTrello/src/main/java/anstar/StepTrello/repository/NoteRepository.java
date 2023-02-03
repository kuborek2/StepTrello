package anstar.StepTrello.repository;

import anstar.StepTrello.Entity.Board;
import anstar.StepTrello.Entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface NoteRepository extends JpaRepository<Note,String>, CrudRepository<Note,String> {

    Note findNoteByNoteId(int noteId);

    void deleteNoteByNoteId(int noteId);

    @Query(value = "SELECT title FROM Note where title like :title")
    Optional<Note> findNoteByTitle(@Param("title" ) String title );

    @Query(value = "")
    Note findNoteByNoteId(Integer noteId);
}

