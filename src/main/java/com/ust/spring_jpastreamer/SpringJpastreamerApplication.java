package com.ust.spring_jpastreamer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.ust.spring_jpastreamer","com.speedment.jpastreamer"})
public class SpringJpastreamerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpastreamerApplication.class, args);
	}

}
