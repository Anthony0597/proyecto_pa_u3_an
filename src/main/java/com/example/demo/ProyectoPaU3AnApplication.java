package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Estudiante;
import com.example.demo.modelo.dto.EstudianteDTO;
import com.example.demo.renta.service.IClienteService;
import com.example.demo.renta.service.IRentaService;
import com.example.demo.renta.service.IVehiculoService;
import com.example.demo.service.IEstudianteService;

@SpringBootApplication
public class ProyectoPaU3AnApplication implements CommandLineRunner{

	@Autowired
	private IClienteService clienteService;
	@Autowired
	private IVehiculoService vehiculoService;
	@Autowired
	private IRentaService rentaService;	
	@Autowired
	private IEstudianteService estudianteService;	
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoPaU3AnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//CREATE
		List <Estudiante> estu = this.estudianteService.buscarPorNombreCriteriaAndOR("Anthony", "Sandoval", "M");
		System.out.println("consulta 1: "+estu.get(0));	
		
		estu = this.estudianteService.buscarPorNombreCriteriaAndOR("Martha", "Cumbal", "Femenino");
		System.out.println("consulta 1: "+estu.get(0));	
		
	}

}
