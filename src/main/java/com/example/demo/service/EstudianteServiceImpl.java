package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Estudiante;
import com.example.demo.repo.IEstudianteRepo;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	IEstudianteRepo estudianteRepo;
	
	@Override
	public Estudiante buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscarPorNombreQuery(nombre);
	}

	@Override
	public Estudiante buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscarPorApellidoQuery(apellido);
	}

	@Override
	public Estudiante buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscarPorCedulaQuery(cedula);
	}

	@Override
	public Estudiante buscarPorFechaNacimiento(LocalDateTime fechaNacimiento) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscarPorFechaNacimientoQuery(fechaNacimiento);
	}

	@Override
	public Estudiante buscarPorGenero(String genero) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscarPorGeneroQuery(genero);
	}

	public Estudiante buscarPorNombreTypedQuery(String nombre) {
		return this.estudianteRepo.buscarPorNombreTypedQuery(nombre);
	}
	
	public Estudiante buscarPorNombreNamedQuery(String nombre) {
		return this.estudianteRepo.buscarPorNombreNamedQuery(nombre);
	}
	
	public Estudiante buscarPorNombreNamedQueryTyped(String nombre) {
		return this.estudianteRepo.buscarPorNombreNamedQueryTyped(nombre);
	}
	
	public Estudiante buscarPorNombreNativeQuery(String nombre) {
		return this.estudianteRepo.buscarPorNombreNativeQuery(nombre);
	}
	public Estudiante buscarPorNombreNativeQueryTypedNamed(String nombre) {
		return this.estudianteRepo.buscarPorNombreNativeQueryTypedNamed(nombre);
	}
	
	public List<Estudiante> buscarPorNombreQueryList(String nombre){
		return this.estudianteRepo.buscarPorNombreNamedQueryList(nombre);
	}
	
	public Estudiante buscarPorNombreQueryListFirst(String nombre){
		return this.estudianteRepo.buscarPorNombreQueryListFirst(nombre);
	}
	
	public List<Estudiante> buscarPorNombreNamedQueryList(String nombre){
		return null;
	}
	public List<Estudiante> buscarPorNombreNativeQueryTypedNamedList(String nombre){
		return null;
	}
	
}
