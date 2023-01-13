package anstar.StepTrello;

import anstar.StepTrello.Entity.User;
import anstar.StepTrello.mapper.BoardDtoToBoard;
import anstar.StepTrello.mapper.UserDtoToUser;
import anstar.StepTrello.model.UserDto;
import anstar.StepTrello.repository.BoardRepository;
import anstar.StepTrello.repository.UserRepository;
import anstar.StepTrello.service.BusinessLogic;
import anstar.StepTrello.service.impl.BusinessLogicImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class UserTest {

    @InjectMocks
    BusinessLogicImpl businessLogic;

    @Mock
    UserRepository userRepository;

    @Mock
    UserDtoToUser userDtoToUser;


    @Tag("User")

    /**
     * Login must be longer than 5 characters,
     * Email must be valid,
     * Password must have 1 capital letter, 1 lowercase letter and number
     *
     */

    @Test
    void canCreateValidUser() {

        //given
        String email = "adam123@gmail.com";
        String login = "adam123";
        String password = "adam123";
        UserDto user = new UserDto(
                login,
                email,
                password
        );

        //when
        Optional<UserDto> result = businessLogic.saveUser(user);

        //then
        assertTrue(result.isPresent());
        assertTrue(result.get().getEmail() == email);
        assertTrue(result.get().getLogin() == login);
        assertTrue(result.get().getPassword() == password);

    }

    @ParameterizedTest
    @CsvSource({
            "adam, adam123,  bomba123",
            "adam@gmail.com, adam123, Bomba",
            "adam@gmail.com, adam123, bomba",
            "adam@gmail.com, adam, bomba1",
            "adamgmail.com, adam, bomba",
            ",adam,bb",
            " , , ",
            ",,",

    })

    void canCreateNonValidUser(String email, String login, String password) {

        //given
        UserDto user = new UserDto(
                login,
                email,
                password
        );

        //when
        Optional<UserDto> result = businessLogic.saveUser(user);

        //then
        assertFalse(result.isPresent());
        assertFalse(result.get().getEmail() == email);
        assertFalse(result.get().getLogin() == login);
        assertFalse(result.get().getPassword() == password);


    }

    @Test
    void canUserBeDeleted() {

        //given
        String email = "adam123@gmail.com";
        String login = "adam123";
        String password = "adam123";
        UserDto user = new UserDto(
                login,
                email,
                password
        );

        //when
        businessLogic.deleteUser(user.getLogin());
        Optional<User> deletedUser1 = userRepository.findUserByUsername(user.getLogin());

        //then
        assertTrue(deletedUser1.isEmpty());

    }

    @Test
    void userShouldNotBeDeleted(String email, String login, String password) {

        //given
        UserDto user = new UserDto(
                login,
                email,
                password
        );

        //when
        businessLogic.deleteUser(user.getLogin());
        Optional<User> deletedUser1 = userRepository.findUserByUsername(user.getLogin());

        //then
        assertFalse(deletedUser1.isEmpty());

    }

//
//    /**
//     * Login must be longer than 5 characters,
//     * Email must be valid,
//     * Password must have 1 capital letter, 1 lowercase letter and number
//     *
//     */
//
//    @ParameterizedTest
//    @CsvSource({
//            "adam, adam123,  bomba123",
//            "adam@gmail.com, adam123, Bomba",
//            "adam@gmail.com, adam123, bomba",
//            "adam@gmail.com, adam, bomba1",
//            "adamgmail.com, adam, bomba",
//            ",adam,bb",
//            " , , ",
//            ",,",
//
//    })
//
//    void canCreateNonValidUser(String email, String login, String password) {
//
//        //given
//        UserDto user = new UserDto(
//                login,
//                email,
//                password
//        );
//
//        //when
//        Optional<UserDto> result = businessLogic.saveUser(user);
//
//        //then
//        assertFalse(result.isPresent());
//        assertFalse(result.get().getEmail() == email);
//        assertFalse(result.get().getLogin() == login);
//        assertFalse(result.get().getPassword() == password);
//
//
//    }
//
//    @ParameterizedTest
//    void canUserBeDeleted() {
//
//        //given
//        String email = "adam123@gmail.com";
//        String login = "adam123";
//        String password = "adam123";
//        UserDto user = new UserDto(
//                login,
//                email,
//                password
//        );
//
//        //when
//        Optional<UserDto> result = businessLogic.deleteUser(user.getLogin());
//
//        //then
//        assertTrue(result.isPresent());
//        assertTrue(result.get().getEmail() == email);
//        assertTrue(result.get().getLogin() == login);
//        assertTrue(result.get().getPassword() == password);
//
//    }
//
//    @ParameterizedTest
//    @CsvSource({
//            "adam, adam123,  bomba123",
//            "adam@gmail.com, adam123, Bomba",
//            "adam@gmail.com, adam123, bomba",
//            "adam@gmail.com, adam, bomba1",
//            "adamgmail.com, adam, bomba",
//            ",adam,bb",
//            " , , "
//    })
//    void userShouldNotBeDeleted(String email, String login, String password) {
//
//        //given
//        UserDto user = new UserDto(
//                login,
//                email,
//                password
//        );
//
//        //when
//        Optional<UserDto> result = businessLogic.deleteUser(user.getLogin());
//
//        //then
//        assertFalse(result.isPresent());
//        assertFalse(result.get().getEmail() == email);
//        assertFalse(result.get().getLogin() == login);
//        assertFalse(result.get().getPassword() == password);
//    }
//
//
//



}
