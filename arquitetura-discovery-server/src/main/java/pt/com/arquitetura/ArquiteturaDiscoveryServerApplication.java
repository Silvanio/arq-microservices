package pt.com.arquitetura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ArquiteturaDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArquiteturaDiscoveryServerApplication.class, args);
	}

}
