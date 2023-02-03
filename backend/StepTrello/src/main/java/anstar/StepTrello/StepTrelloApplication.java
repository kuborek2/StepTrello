package anstar.StepTrello;

import anstar.StepTrello.Entity.Role;
import anstar.StepTrello.Entity.User;
import anstar.StepTrello.controller.UserController;
import anstar.StepTrello.model.UserDto;
import anstar.StepTrello.service.impl.BusinessLogicImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;


@SpringBootApplication
@EntityScan("anstar.StepTrello.Entity")
public class StepTrelloApplication {

	public static void main(String[] args) {

		SpringApplication.run(StepTrelloApplication.class, args);
	}

	@Bean
	CommandLineRunner run(BusinessLogicImpl businessLogic) {
		return args -> {
			businessLogic.saveUser(
					new UserDto("adam1",
							"adam1@gmail.com",
							"adam1",
							new ArrayList<>()
			));
			businessLogic.addRoleToUser("adam1","USER");
		};

	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
