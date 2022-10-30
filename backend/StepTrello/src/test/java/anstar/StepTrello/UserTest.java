package anstar.StepTrello;

import anstar.StepTrello.model.UserDto;
import anstar.StepTrello.service.impl.BusinessLogicImpl;
import org.junit.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    final BusinessLogicImpl businessLogicImpl = new BusinessLogicImpl();

    @Tag("User")

    /**
     * Login must be longer than 5 characters,
     * Email must be valid,
     * Password must have 1 capital letter, 1 lowercase letter and number
     *
     */

    @ParameterizedTest
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
        Optional<UserDto> result = businessLogicImpl.saveUser(user);

        //then
        assertTrue(result.isPresent());
        assertTrue(result.get().getEmail() == email);
        assertTrue(result.get().getLogin() == login);
        assertTrue(result.get().getPassword() == password);

    }

    /**
     * Login must be longer than 5 characters,
     * Email must be valid,
     * Password must have 1 capital letter, 1 lowercase letter and number
     *
     */

    @ParameterizedTest
    @CsvSource({
            "adam, adam123,  bomba123",
            "adam@gmail.com, adam123, Bomba",
            "adam@gmail.com, adam123, bomba",
            "adam@gmail.com, adam, bomba1",
            "adamgmail.com, adam, bomba",
            ",adam,bb",
            " , , "
    })

    void canCreateNonValidUser(String email, String login, String password) {

        //given
        UserDto user = new UserDto(
                login,
                email,
                password
        );

        //when
        Optional<UserDto> result = businessLogicImpl.saveUser(user);

        //then
        assertFalse(result.isPresent());
        assertFalse(result.get().getEmail() == email);
        assertFalse(result.get().getLogin() == login);
        assertFalse(result.get().getPassword() == password);


    }

    @ParameterizedTest
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
        Optional<UserDto> result = businessLogicImpl.deleteUser(user);

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
            " , , "
    })
    void userShouldNotBeDeleted(String email, String login, String password) {

        //given
        UserDto user = new UserDto(
                login,
                email,
                password
        );

        //when
        Optional<UserDto> result = businessLogicImpl.deleteUser(user);

        //then
        assertFalse(result.isPresent());
        assertFalse(result.get().getEmail() == email);
        assertFalse(result.get().getLogin() == login);
        assertFalse(result.get().getPassword() == password);
    }






}
