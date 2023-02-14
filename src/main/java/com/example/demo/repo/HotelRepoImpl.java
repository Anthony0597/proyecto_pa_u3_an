package com.example.demo.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class HotelRepoImpl implements IHotelRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.tipo=: datoTipo",Hotel.class);
		myQuery.setParameter("datoTipo", tipoHabitacion);
		List<Hotel> lista=myQuery.getResultList();
		//Bajo demanda
		for(Hotel h:lista) {
			List<Habitacion> temp= null;
			for(Habitacion ha : h.getHabitaciones()) {
				if(ha.getTipo().equals(tipoHabitacion)) {
					temp.add(ha);
				}
				h.setHabitaciones(temp);
			}
			
			
		}
		return lista;
	}

	@Override
	public List<Hotel> buscarHotelOuterRightJoin(String tipoHabitacion) {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha WHERE ha.tipo=: datoTipo",Hotel.class);
		myQuery.setParameter("datoTipo", tipoHabitacion);
		List<Hotel> lista=myQuery.getResultList();
		/*for(Hotel h:lista) {
			h.getHabitaciones().size();
		}*/
		return lista;
	}

	@Override
	public List<Hotel> buscarHotelOuterLeftJoin(String tipoHabitacion) {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha WHERE ha.tipo=: datoTipo",Hotel.class);
		myQuery.setParameter("datoTipo", tipoHabitacion);
		List<Hotel> lista=myQuery.getResultList();
		for(Hotel h:lista) {
			h.getHabitaciones().size();
		}
		return lista;
	}

	@Override
	public List<Hotel> buscarHotelOuterFullJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> buscarHotelFetchJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return null;
	}

}
