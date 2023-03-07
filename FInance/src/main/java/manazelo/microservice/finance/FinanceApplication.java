package manazelo.microservice.finance;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableEurekaClient
public class FinanceApplication {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

    public static void main(String[] args) {



		SpringApplication.run(FinanceApplication.class, args);













	}

}
