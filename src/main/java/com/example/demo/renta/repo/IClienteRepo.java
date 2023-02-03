package com.example.demo.renta.repo;

import com.example.demo.renta.modelo.Cliente;

public interface IClienteRepo {
	public void insertar(Cliente cliente);
	public void actualizar(Cliente cliente);
	public Cliente buscar(Integer id);
	public void eliminar(Integer id);
	public Cliente buscarCedula(String cedula);
}
