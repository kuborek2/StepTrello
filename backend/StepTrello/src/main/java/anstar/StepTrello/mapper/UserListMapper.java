package anstar.StepTrello.mapper;

import anstar.StepTrello.Entity.Role;
import anstar.StepTrello.Entity.User;
import anstar.StepTrello.model.UserDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserListMapper implements Converter<List<UserDto>, List<User>> {
    @Override
    public List<UserDto> convert(List<User> users) {

        return users.stream()
                .map(user -> new UserDto(user.getUsername(),user.getEmail(),user.getPassword(), new ArrayList<>(user.getRoles()))).collect(Collectors.toList());
    }
}
