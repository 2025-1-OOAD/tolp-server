package ooad.tolp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ooad.tolp.user.domain.User;

@SpringBootApplication
public class TolpApplication {

	public static void main(String[] args) {
		SpringApplication.run(TolpApplication.class, args);



		try {
			User user = new User();
			user.setUsername("tester");
			user.setEmail("tester@example.com");
			System.out.println("normal operation: " + user.getUsername());

		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
			e.printStackTrace();
		}
	}



}
