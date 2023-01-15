package anstar.StepTrello.repository;

import anstar.StepTrello.Entity.User;
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
public interface UserRepository extends JpaRepository<User, String>, CrudRepository<User,String> {

// , nativeQuery = true
//    @Query(value = "SELECT us.username FROM User us WHERE us.username like %:search_login% " )
//    User findUserByLogin(@Param("search_login") String login);
//    us WHERE us.username LIKE %:search_login%
    @Query
    User findUserByUsername(String userName);


//    @Query(value = "SELECT username FROM User where username like :login")
//    User findUserByUsername(@Param("login" ) String login );

    @Modifying
    @Query(value = "DELETE FROM User us where us.username = :login")
    void deleteUserByUsername(@Param("login") String login);




}
