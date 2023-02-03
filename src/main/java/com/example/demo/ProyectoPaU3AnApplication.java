package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

@SpringBootApplication
public class ProyectoPaU3AnApplication implements CommandLineRunner{

	@Autowired
	private IEstudianteService estudianteService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoPaU3AnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Estudiante estu1 = this.estudianteService.buscarPorApellido("Naranjo");
		System.out.println(estu1);
		Estudiante estu2 = this.estudianteService.buscarPorCedula("1652349756");
		System.out.println(estu2);
		Estudiante estu3 = this.estudianteService.buscarPorFechaNacimiento(LocalDateTime.of(1995, 8, 25, 0, 0));
		System.out.println(estu3);
		Estudiante estu4 = this.estudianteService.buscarPorGenero("Femenino");
		System.out.println(estu4);
	}

}
