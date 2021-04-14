package lucasti.desafiob2w;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DesafioB2wApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioB2wApplication.class, args);
	}

}
