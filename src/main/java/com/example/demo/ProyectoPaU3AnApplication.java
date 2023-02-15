package com.example.demo;

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
import com.example.demo.service.IHabitacionService;
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
	
	@Autowired
	private IHabitacionService habitacionService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoPaU3AnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//CREATE
		List <Hotel> hoteles = null;
		
		hoteles=this.hotelService.buscarHotelFetchJoin("VIP");
		for(Hotel h:hoteles) {
			System.out.println(h.getNombre());
			for(Habitacion ha:h.getHabitaciones()) {
				System.out.println("Las habitacion de: "+h.getNombre()+" es :"+ha.getNumero());
			}
		}
		
		hoteles =this.hotelService.buscarHotelOuterLeftJoin();
		for(Hotel h:hoteles) {
			System.out.println(h.getNombre());
			for(Habitacion ha:h.getHabitaciones()) {
				System.out.println("Las habitacion de: "+h.getNombre()+" es :"+ha.getNumero());
			}
		}
		
		
		List<Habitacion> habitaciones =this.habitacionService.buscarHabitacionOuterLeftJoin();
		for(Habitacion ha:habitaciones) {
			System.out.println(ha!=null? ha.getNumero():null);
		}
		
		hoteles =this.hotelService.buscarHotelOuterRightJoin();
		for(Hotel h:hoteles) {
			System.out.println(h!=null?h.getNombre():null);
		}
		
		
		habitaciones =this.habitacionService.buscarHabitacionOuterRightJoin();
		for(Habitacion ha:habitaciones) {
			System.out.println(ha!=null? ha.getNumero():null);
			//System.out.println(ha.getHotel());
		}
		
	}

}
