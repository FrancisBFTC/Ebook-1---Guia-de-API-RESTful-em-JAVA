package br.com.myapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.myapi.model.User;
import br.com.myapi.service.UserService;

@SpringBootApplication
public class MyapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyapiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserService service){
		return args -> {
			System.out.println();
			System.out.println("Gravando no banco de dados 2...");
			
			User user = new User();
			user.setName("Joao");
			service.saveUser(user);

			for(User u : service.findAllUsers())
				System.out.println(u);

			User firstUser = service.findUserById(2);
			System.out.println(firstUser);
		};
	}

}
