package com.example.demo.renta.service;

import com.example.demo.renta.modelo.Vehiculo;

public interface IVehiculoService {
	public void guardar(Vehiculo vehiculo);
	public void modificar(Vehiculo vehiculo);
	public Vehiculo buscar(Integer id);
	public void borrar(Integer id);
}
