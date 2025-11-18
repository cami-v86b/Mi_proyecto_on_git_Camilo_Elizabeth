package com.example.Emailback;

import com.example.Emailback.config.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
public class EmailbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailbackApplication.class, args);
	}

}
