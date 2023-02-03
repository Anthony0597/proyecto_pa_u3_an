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
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoPaU3AnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//CREATE
				Vehiculo vehi = new Vehiculo();
				vehi.setNumeroPuertas(5);
				vehi.setPlaca("IBR-2479");
				vehi.setTipoDireccion("hidraulica");
				vehi.setTraccion("4x2");
								
				Cliente clie = new Cliente();
				clie.setCedula("1151561532");
				clie.setNombre("Mauricio");
				clie.setApellido("Torres");
				clie.setEdad(28);				
				
				this.vehiculoService.guardar(vehi);
				this.clienteService.guardar(clie);
				
				this.rentaService.ingresar(vehi.getPlaca(), clie.getCedula());
				
	}

}
