package de.adesso.mholzmannfeignclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MholzmannFeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MholzmannFeignClientApplication.class, args);
	}

}
