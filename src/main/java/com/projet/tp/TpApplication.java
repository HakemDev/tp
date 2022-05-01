package com.projet.tp;

import com.projet.tp.entity.Administarteur;
import com.projet.tp.entity.Cooperative;
import com.projet.tp.service.CooperativeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class TpApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
		//here we want add data to database when we load application
	CommandLineRunner run(CooperativeService userService)
	{
		return args->{
			userService.saveorUpdateAdmini(new Administarteur(4,"admin@","12344","souss massa","agadir","2022-10-10"));

		};
	}
}
