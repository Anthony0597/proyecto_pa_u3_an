package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepoImpl implements IEstudianteRepo {
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Estudiante buscarPorNombreQuery(String nombre) {
		// TODO Auto-generated method stub
		//select * from estudiante where estu_nombre = 'Anthony'(SQL)
		//select e from Estudiante e where e.nombre = :datoNombre (JPQL)
	Query jplQuery= this.entityManager.createQuery(
			"select e from Estudiante e where e.nombre = :datoNombre");
	jplQuery.setParameter("datoNombre", nombre);
		return (Estudiante) jplQuery.getSingleResult();//solo retorna un 
		//unico resultado y es de tipo objeto ordinario
	}

	@Override
	public Estudiante buscarPorApellidoQuery(String apellido) {
		// TODO Auto-generated method stub
		return null;
	}

}
