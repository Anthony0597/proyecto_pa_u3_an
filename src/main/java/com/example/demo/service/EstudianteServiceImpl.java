package com.example.demo.service;

import java.time.LocalDateTime;

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

}
