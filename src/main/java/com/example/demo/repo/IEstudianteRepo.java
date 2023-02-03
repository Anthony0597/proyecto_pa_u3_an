package com.example.demo.repo;

import java.time.LocalDateTime;

import com.example.demo.modelo.Estudiante;

public interface IEstudianteRepo {
	public Estudiante buscarPorNombreQuery(String nombre);
	public Estudiante buscarPorApellidoQuery(String apellido);
	public Estudiante buscarPorCedulaQuery(String cedula);
	public Estudiante buscarPorFechaNacimientoQuery(LocalDateTime fechaNacimiento);
	public Estudiante buscarPorGeneroQuery(String genero);
}
