package anstar.StepTrello.mapper;

import anstar.StepTrello.Entity.User;
import anstar.StepTrello.model.UserDto;
import org.springframework.stereotype.Component;


@Component
public class UserDtoToUser implements Converter< User ,UserDto>{

    @Override
    public User convert(UserDto userDto) {
        return new User.Builder()
                .user_name(userDto.getLogin())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();

    }
}
