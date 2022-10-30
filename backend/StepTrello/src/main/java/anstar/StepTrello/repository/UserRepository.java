package anstar.StepTrello.repository;

import anstar.StepTrello.model.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDto,Integer > {
}
