package ru.zernoproject.zerno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class ZernoCoffeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZernoCoffeeApplication.class, args);
	}

}
