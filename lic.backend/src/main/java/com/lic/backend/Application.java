package com.lic.backend;

import com.lic.backend.model.User;
import com.lic.backend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// Seed default user
//	@Bean
//	CommandLineRunner run(UserRepository, PasswordEncoder passwordEncoder) {
//		return args -> {
//			if (userRepository.findByUsername("admin").isEmpty()) {
//				User admin = new User();
//				admin.setName("admin");
//				admin.setPassword(passwordEncoder.encode("admin123"));
//				admin.setRole(Set.of("ROLE_ADMIN").toString());
//				userRepository.save(admin);
//			}
//
//			if (userRepository.findByUsername("user").isEmpty()) {
//				User user = new User();
//				user.setName("user");
//				user.setPassword(passwordEncoder.encode("user123"));
//				user.setRole(Set.of("ROLE_USER").toString());
//				userRepository.save(user);
//			}
//		};
//	}
//
//
//	// Password encoder bean
	@Bean(name = "appPasswordEncoder")
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
