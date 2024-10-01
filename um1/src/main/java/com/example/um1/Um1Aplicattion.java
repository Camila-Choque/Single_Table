package com.example.um1;

import com.example.um1.entidades.Profesor;
import com.example.um1.enumeraciones.Titulo;
import com.example.um1.repositorios.AlumnoRepository;
import com.example.um1.repositorios.PersonaRepository;
import com.example.um1.repositorios.ProfesorRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class um1Application {


	private static final Logger logger = LoggerFactory.getLogger(um1Application.class);

	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private ProfesorRepository profesorRepository;

	@Autowired
	private AlumnoRepository alumnoRepository;
	public static void main(String[] args) {
		SpringApplication.run(um1Application.class, args);

		System.out.println("funcionando");
	}




	@Bean
	@Transactional
	CommandLineRunner init(PersonaRepository personaRepository,
						   AlumnoRepository alumnoRepository,
						   ProfesorRepository profesorRepository) {
		return args -> {
			// Creo un objeto alumno
			 Profesor pro1 = Profesor.builder()
					.nombre("Marta")
					.nombre("Guerra")
					.fechaIngreso(LocalDate.of(2020, 1, 1))
					.cantHijos(4)
					.titulo(Titulo.MASTER)
					.sueldo(new BigDecimal("123.45"))
					.build();

			// Lo grabo a través del repositorio de Spring
			profesorRepository.save(pro1);











		};

	};




}
