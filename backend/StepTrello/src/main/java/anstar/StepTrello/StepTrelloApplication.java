package anstar.StepTrello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;




@SpringBootApplication
@EntityScan("anstar.StepTrello.Entity")
public class StepTrelloApplication {

	public static void main(String[] args) {

		SpringApplication.run(StepTrelloApplication.class, args);
	}

}
