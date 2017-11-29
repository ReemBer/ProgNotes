package by.bsuir.prognotes;

import by.bsuir.prognotes.security.SecurityConfiguration;
import by.bsuir.prognotes.web.WebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@Import({WebConfiguration.class, SecurityConfiguration.class})
@PropertySource({"classpath:application.properties", "classpath:custom.properties"})
public class PrognotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrognotesApplication.class, args);
	}
}
