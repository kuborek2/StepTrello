package anstar.StepTrello.controller;

import anstar.StepTrello.model.UserDto;
import anstar.StepTrello.service.BusinessLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import anstar.StepTrello.service.impl.BusinessLogicImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class UserController {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(BoardController.class);

    private final BusinessLogic businessLogic;

    @Autowired
    public UserController(BusinessLogic businessLogic) {
        this.businessLogic = businessLogic;
    }

    // Done
    @CrossOrigin
    @PutMapping(value = "/user")
    public ResponseEntity <Optional<UserDto>> addUser(@RequestBody UserDto userDto) {
        LOGGER.info("Add user " + userDto.getLogin() );
        businessLogic.saveUser(userDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Done
    @CrossOrigin
    @DeleteMapping(value = "/user/{userName}")
    public ResponseEntity <Optional<UserDto> > deleteUser(@PathVariable String userName){
        LOGGER.info("Delete this user " + userName );
        businessLogic.deleteUser(userName);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/user/")
    public ResponseEntity <Optional<UserDto> >  getOneUser(@RequestParam(name = "login") String login) {

        Optional <UserDto> userDto =  businessLogic.getUser(login);

        LOGGER.info("All users found: " + userDto);

        return new ResponseEntity(userDto, HttpStatus.OK);
    }

    // Done
    @CrossOrigin
    @GetMapping(value = "/users")
    public ResponseEntity <List<UserDto>>  getUser() {
        List<UserDto> userDto =  businessLogic.getAllUsers();

        LOGGER.info("All users found: " + userDto);

        return new ResponseEntity(userDto, HttpStatus.OK);
    }



}
