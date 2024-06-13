package com.qr.RocketStudio.qrRocketStudio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.qr.RocketStudio.qrRocketStudio.repository")
public class QrRocketStudioApplication {

	public static void main(String[] args) {
		SpringApplication.run(QrRocketStudioApplication.class, args);
	}
}
