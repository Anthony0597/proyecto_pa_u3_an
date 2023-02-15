package com.example.demo.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Habitacion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class HabitacionRepoImpl implements IHabitacionRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Habitacion> buscarHabitacionOuterRightJoin() {
		TypedQuery<Habitacion> myQuery = this.entityManager.createQuery(
				"SELECT ha FROM Hotel h RIGHT JOIN h.habitaciones ha",Habitacion.class);
			
		return myQuery.getResultList();
	}

	@Override
	public List<Habitacion> buscarHabitacionOuterLeftJoin() {
		TypedQuery<Habitacion> myQuery = this.entityManager.createQuery(
				"SELECT ha FROM Hotel h LEFT JOIN h.habitaciones ha",Habitacion.class);
			
		return myQuery.getResultList();
	}

	@Override
	public List<Habitacion> buscarHabitacionOuterFullJoin() {
		// TODO Auto-generated method stub
		return null;
	}

}
