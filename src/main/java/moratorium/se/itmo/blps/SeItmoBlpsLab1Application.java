package moratorium.se.itmo.blps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ImportAutoConfiguration
public class SeItmoBlpsLab1Application {

	public static void main(String[] args) {
		SpringApplication.run(SeItmoBlpsLab1Application.class, args);
	}

}
