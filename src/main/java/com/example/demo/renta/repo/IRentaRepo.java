 package com.example.demo.renta.repo;

import com.example.demo.renta.modelo.Renta;

public interface IRentaRepo {
	public void insertar(Renta renta);
	public void actualizar(Renta renta);
	public Renta buscar(Integer id);
	public void eliminar(Integer id);
}
