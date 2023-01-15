package anstar.StepTrello.mapper;

import anstar.StepTrello.Entity.User;
import anstar.StepTrello.model.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDto implements Converter<UserDto, User> {
    @Override
    public UserDto convert(User user) {
        return new UserDto(user.getUsername(), user.getEmail(), user.getPassword());
    }
}

