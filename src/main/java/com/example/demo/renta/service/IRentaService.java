package com.example.demo.renta.service;

import com.example.demo.renta.modelo.Renta;

public interface IRentaService {
	public void guardar(Renta renta);
	public void modificar(Renta renta);
	public Renta buscar(Integer id);
	public void borrar(Integer id);
	public void ingresar(String placa, String cedula);
}
