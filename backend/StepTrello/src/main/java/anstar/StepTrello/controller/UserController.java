package anstar.StepTrello.controller;

import anstar.StepTrello.model.BoardDto;
import anstar.StepTrello.model.UserDto;
import anstar.StepTrello.service.BusinessLogic;
import anstar.StepTrello.service.impl.BusinessLogicImpl;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class UserController {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(BoardController.class);

    private final BusinessLogicImpl businessLogic;

    @Autowired
    public UserController(BusinessLogicImpl businessLogic) {
        this.businessLogic = businessLogic;
    }

    @CrossOrigin
    @PutMapping(value = "/user")
    public ResponseEntity <Optional<UserDto>> addUser(@RequestBody UserDto userDto) {
        LOGGER.info("Add user " + userDto.getLogin() );
        Optional <UserDto> newUserDto = businessLogic.saveUser(userDto);

        return new ResponseEntity<>(newUserDto,HttpStatus.CREATED);
    }

    @CrossOrigin
    @DeleteMapping(value = "/user/{userName}")
    public ResponseEntity <Optional<UserDto> > deleteUser(@RequestBody UserDto userDto){
        LOGGER.info("Delete this user" + userDto.getLogin() );
        businessLogic.deleteUser(userDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @CrossOrigin
    @GetMapping(value = "/user")
    public ResponseEntity <UserDto>  getUser(String login) {
        LOGGER.info("find this user" + login);

        UserDto userDto =  businessLogic.getUser(login);

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }


}
