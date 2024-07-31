package br.com.jau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class})
public class Startapp {

	public static void main(String[] args) {
		SpringApplication.run(Startapp.class, args);
	}

}
