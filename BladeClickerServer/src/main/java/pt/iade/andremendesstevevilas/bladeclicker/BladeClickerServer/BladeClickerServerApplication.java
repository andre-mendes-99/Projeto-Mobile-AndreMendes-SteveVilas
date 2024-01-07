package pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "pt.iade.andremendesstevevilas.bladeclicker.BladeClickerServer")
@EnableAutoConfiguration
public class BladeClickerServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BladeClickerServerApplication.class, args);
	}

}
