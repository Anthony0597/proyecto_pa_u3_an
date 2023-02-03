package com.example.demo.renta.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.renta.modelo.Cliente;
import com.example.demo.renta.modelo.Renta;
import com.example.demo.renta.modelo.Vehiculo;
import com.example.demo.renta.repo.IClienteRepo;
import com.example.demo.renta.repo.IRentaRepo;
import com.example.demo.renta.repo.IVehiculoRepo;

@Service
public class RentaServiceImpl implements IRentaService {

	@Autowired
	private IRentaRepo rentaRepo;
	
	@Autowired
	private IClienteRepo clienteRepo;
	
	@Autowired
	private IVehiculoRepo vehiculoRepo;
	
	@Override
	public void guardar(Renta renta) {
		// TODO Auto-generated method stub
		this.rentaRepo.insertar(renta);
	}

	@Override
	public void modificar(Renta renta) {
		// TODO Auto-generated method stub
		this.rentaRepo.actualizar(renta);
	}

	@Override
	public Renta buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.rentaRepo.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.rentaRepo.eliminar(id);
	}

	@Override
	public void ingresar(String placa, String cedula) {
		// TODO Auto-generated method stub
		Vehiculo vehi = this.vehiculoRepo.buscarPlaca(placa);
		Cliente clie = this.clienteRepo.buscarCedula(cedula);
		
		Renta renta = new Renta();
		
		renta.setCliente(clie);
		renta.setVehiculo(vehi);
		renta.setFechaIngreso(LocalDateTime.now());
		renta.setNumeroDias(5);
		renta.setValor(new BigDecimal(300));
		
		List<Renta> rentas= new ArrayList<>();
		rentas.add(renta);
		
		vehi.setClientes(rentas);
		clie.setVehiculos(rentas);
		
		this.clienteRepo.actualizar(clie);
		this.vehiculoRepo.actualizar(vehi);
		
		this.rentaRepo.insertar(renta);
	}

}
