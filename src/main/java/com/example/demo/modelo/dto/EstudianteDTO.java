package com.example.demo.modelo.dto;

public class EstudianteDTO {
	
	private String cedula;
	private String apellido;
	private String nombre;
	
	public EstudianteDTO() {
		
	}
	
	
	public EstudianteDTO(String cedula, String apellido, String nombre) {

		this.cedula = cedula;
		this.apellido = apellido;
		this.nombre = nombre;
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "EstudianteDTO [cedula=" + cedula + ", apellido=" + apellido + ", nombre=" + nombre + ", getCedula()="
				+ getCedula() + ", getApellido()=" + getApellido() + ", getNombre()=" + getNombre() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
