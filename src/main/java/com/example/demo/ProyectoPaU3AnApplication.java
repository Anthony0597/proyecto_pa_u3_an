package com.example.demo;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.renta.modelo.Cliente;
import com.example.demo.renta.modelo.Vehiculo;
import com.example.demo.renta.service.IClienteService;
import com.example.demo.renta.service.IRentaService;
import com.example.demo.renta.service.IVehiculoService;
import com.example.demo.modelo.Estudiante;
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
		Estudiante estu = this.estudianteService.buscarPorNombreTypedQuery("Anthony");
		System.out.println("consulta 1: "+estu);		
		
		estu = this.estudianteService.buscarPorNombreNamedQuery("Anthony");
		System.out.println("consulta 2: "+estu);
		
		estu = this.estudianteService.buscarPorNombreNamedQueryTyped("Anthony");
		System.out.println("consulta 3: "+estu);
		
		estu = this.estudianteService.buscarPorNombreNativeQuery("Anthony");
		System.out.println("consulta 4: "+estu);
		
		//estu = this.estudianteService.buscarPorNombreNativeQueryTypedNamed("Anthony");
		//System.out.println("consulta 5: "+estu);
	}

}
