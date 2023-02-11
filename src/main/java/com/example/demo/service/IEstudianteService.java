package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.modelo.Estudiante;
import com.example.demo.modelo.dto.EstudianteDTO;

import jakarta.persistence.TypedQuery;

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
	public List<Estudiante> buscarPorNombreQueryList(String nombre);
	public List<Estudiante> buscarPorNombreNamedQueryList(String nombre);
	public List<Estudiante> buscarPorNombreNativeQueryTypedNamedList(String nombre);
	public Estudiante buscarPorNombreQueryListFirst(String nombre);
	public EstudianteDTO buscarPorNombreTypedQueryDTO(String nombre);
	public Estudiante buscarPorNombreCriteria(String nombre);
	public List<Estudiante> buscarPorNombreCriteriaAndOR(String nombre, String apellido, String bandera);
	public int eliminarPorApellido(String apellido);
	public int actualizarPorApellido(String apellido,String nombre);
	
}
