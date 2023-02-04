package com.example.demo.service;

import java.time.LocalDateTime;

import com.example.demo.modelo.Estudiante;

public interface IEstudianteService {
	public Estudiante buscarPorNombre(String nombre);
	public Estudiante buscarPorApellido(String apellido);
	public Estudiante buscarPorCedula(String cedula);
	public Estudiante buscarPorFechaNacimiento(LocalDateTime fechaNacimiento);
	public Estudiante buscarPorGenero(String genero);
	public Estudiante buscarPorNombreTypedQuery(String nombre);
	public Estudiante buscarPorNombreNamedQuery(String nombre);
	public Estudiante buscarPorNombreNamedQueryTyped(String nombre);
	public Estudiante buscarPorNombreNativeQuery(String nombre);
	public Estudiante buscarPorNombreNativeQueryTypedNamed(String nombre);
}
