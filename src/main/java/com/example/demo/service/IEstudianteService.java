package com.example.demo.service;

import java.time.LocalDateTime;

import com.example.demo.modelo.Estudiante;

public interface IEstudianteService {
	public Estudiante buscarPorNombre(String nombre);
	public Estudiante buscarPorApellido(String apellido);
	public Estudiante buscarPorCedula(String cedula);
	public Estudiante buscarPorFechaNacimiento(LocalDateTime fechaNacimiento);
	public Estudiante buscarPorGenero(String genero);
}
