package anstar.StepTrello.repository;

import anstar.StepTrello.model.UserDto;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDto,Integer > {



    static Optional<UserDto> findOneByLogin(String login);

}
