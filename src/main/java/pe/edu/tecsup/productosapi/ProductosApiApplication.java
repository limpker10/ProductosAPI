package pe.edu.tecsup.productosapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductosApiApplication.class, args);
	}

}
