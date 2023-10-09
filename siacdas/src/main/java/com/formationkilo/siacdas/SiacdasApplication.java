package com.formationkilo.siacdas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@Configuration         |
//@ComponentScan         |
//@EnableAutoConfuration |-->are alternatives

@SpringBootApplication 
public class SiacdasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiacdasApplication.class, args);
	}

}
