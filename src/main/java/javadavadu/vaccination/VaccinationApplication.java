package javadavadu.vaccination;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan({"controller","business","config"})
@EntityScan("data")
@EnableJpaRepositories("data.repositories")
public class VaccinationApplication {
	public static void main(String[] args) {
		SpringApplication.run(VaccinationApplication.class, args);
	}
}

