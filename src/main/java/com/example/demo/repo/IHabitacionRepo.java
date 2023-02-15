package com.example.demo.repo;

import java.util.List;

import com.example.demo.modelo.Habitacion;

public interface IHabitacionRepo {
	
	//
	public List<Habitacion> buscarHabitacionOuterRightJoin();
	public List<Habitacion> buscarHabitacionOuterLeftJoin();
	public List<Habitacion> buscarHabitacionOuterFullJoin();
}
