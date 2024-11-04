package org.spring.halloween;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HalloweenApplication {

	public static void main(String[] args) {
		SpringApplication.run(HalloweenApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			System.out.println("\nPrimeiro Arg: " + args[0] + "\n");
		};
	}
}
