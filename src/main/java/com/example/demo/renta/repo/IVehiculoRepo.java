package com.example.demo.renta.repo;

import com.example.demo.renta.modelo.Vehiculo;

public interface IVehiculoRepo {
	public void insertar(Vehiculo vehiculo);
	public void actualizar(Vehiculo vehiculo);
	public Vehiculo buscar(Integer id);
	public void eliminar(Integer id);
	public Vehiculo buscarPlaca(String placa);
}
