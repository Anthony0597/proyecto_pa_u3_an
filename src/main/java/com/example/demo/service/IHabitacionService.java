package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Habitacion;

public interface IHabitacionService {
	public List<Habitacion> buscarHabitacionOuterRightJoin();
	public List<Habitacion> buscarHabitacionOuterLeftJoin();
	public List<Habitacion> buscarHabitacionOuterFullJoin();
}
