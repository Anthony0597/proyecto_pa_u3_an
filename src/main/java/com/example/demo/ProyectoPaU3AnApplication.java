package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.Hotel;
import com.example.demo.renta.service.IClienteService;
import com.example.demo.renta.service.IRentaService;
import com.example.demo.renta.service.IVehiculoService;
import com.example.demo.service.IEstudianteService;
import com.example.demo.service.IHotelService;

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
	@Autowired
	private IHotelService hotelService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoPaU3AnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//CREATE
		List <Hotel> hoteles = null;
		
		hoteles =this.hotelService.buscarHotelInnerJoin("VIP");
		//hoteles=this.hotelService.buscarHotelOuterRightJoin("VIP");
		//hoteles=this.hotelService.buscarHotelOuterLeftJoin("VIP");
		//hoteles=this.hotelService.buscarHotelOuterFullJoin(null);
		//hoteles=this.hotelService.buscarHotelFetchJoin(null);*/
		
		
		for(Hotel h:hoteles) {
			System.out.println(h.getNombre());
			for(Habitacion ha:h.getHabitaciones()) {
				System.out.println("Las habitacion de: "+h.getNombre()+" es :"+ha.getNumero());
			}
		}
		
		
	}

}
