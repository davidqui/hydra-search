package co.mil.ejercito.hydrasearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HydrasearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(HydrasearchApplication.class, args);
	}
}
