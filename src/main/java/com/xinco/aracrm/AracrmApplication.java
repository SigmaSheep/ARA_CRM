package com.xinco.aracrm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xinco.aracrm.dao")
public class AracrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(AracrmApplication.class, args);
	}

}
