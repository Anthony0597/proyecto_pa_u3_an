package com.example.demo.renta.service;

import com.example.demo.renta.modelo.Cliente;

public interface IClienteService {
	public void guardar(Cliente cliente);
	public void modificar(Cliente cliente);
	public Cliente buscar(Integer id);
	public void borrar(Integer id);
}
