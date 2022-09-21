package com.registro.util;

import org.springframework.boot.SpringApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.registro.SpringSecurityRegistroEmpleadosApplication;


public class PasswordEncoderGenerator {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityRegistroEmpleadosApplication.class, args);
		
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println(passwordEncoder.encode("password"));
		
	}
	
	

}
