package com.example.demo.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Estudiante;
import com.example.demo.modelo.DTO.EstudianteDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
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
		Query jplQuery= this.entityManager.createQuery(
				"select e from Estudiante e where e.apellido = :datoApellido");
		jplQuery.setParameter("datoApellido", apellido);
			return (Estudiante) jplQuery.getSingleResult();
	}

	@Override
	public Estudiante buscarPorCedulaQuery(String cedula) {
		// TODO Auto-generated method stub
		Query jplQuery= this.entityManager.createQuery(
				"select e from Estudiante e where e.cedula = :datoCedula");
		jplQuery.setParameter("datoCedula", cedula);
			return (Estudiante) jplQuery.getSingleResult();
	}

	@Override
	public Estudiante buscarPorFechaNacimientoQuery(LocalDateTime fechaNacimiento) {
		// TODO Auto-generated method stub
		Query jplQuery= this.entityManager.createQuery(
				"select e from Estudiante e where e.fechaNacimiento = :datoFechaNacimiento");
		jplQuery.setParameter("datoFechaNacimiento", fechaNacimiento);
			return (Estudiante) jplQuery.getSingleResult();
	}

	@Override
	public Estudiante buscarPorGeneroQuery(String genero) {
		// TODO Auto-generated method stub
		Query jplQuery =  this.entityManager.createQuery(
				"select e from Estudiante e where e.genero = :datoGenero");
		jplQuery.setParameter("datoGenero", genero);
		return (Estudiante) jplQuery.getSingleResult();
	}
	
	@Override
	public Estudiante buscarPorNombreTypedQuery(String nombre) {
		TypedQuery<Estudiante> myTypedQuery = this.entityManager.createQuery(
				"select e from Estudiante e where e.nombre = :datoNombre", Estudiante.class);
		myTypedQuery.setParameter("datoNombre", nombre);
		return myTypedQuery.getSingleResult();
		
	}
	
	public Estudiante buscarPorNombreNamedQuery(String nombre) {
		Query myQuery= this.entityManager.createNamedQuery("Estudiante.buscarPorNombre");
		myQuery.setParameter("datoNombre", nombre);
		return (Estudiante)myQuery.getSingleResult();
	}

	
	public Estudiante buscarPorNombreNamedQueryTyped(String nombre) {
		TypedQuery <Estudiante>myQuery= this.entityManager.createNamedQuery("Estudiante.buscarPorNombre",Estudiante.class);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getSingleResult();
	}
	
	public Estudiante buscarPorNombreNativeQuery(String nombre) {
		Query myQuery = this.entityManager.createNativeQuery(
				"select * from estudiante estu where estu_nombre = :datoNombre", Estudiante.class);
		myQuery.setParameter("datoNombre", nombre);
		return (Estudiante) myQuery.getSingleResult();
	}
	
	public Estudiante buscarPorNombreNativeQueryTypedNamed(String nombre) {
		TypedQuery<Estudiante> myQuery= this.entityManager.createNamedQuery("Estudiante.buscarPorNombreNative",Estudiante.class);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getSingleResult();
	}
	
	@Override
	public List<Estudiante> buscarPorNombreQueryList(String nombre) {
		Query jplQuery= this.entityManager.createQuery(
			"select e from Estudiante e where e.nombre = :datoNombre");
		jplQuery.setParameter("datoNombre", nombre);
		return  jplQuery.getResultList();
	}
	
	@Override
	public Estudiante buscarPorNombreQueryListFirst(String nombre) {
		Query jplQuery= this.entityManager.createQuery(
			"select e from Estudiante e where e.nombre = :datoNombre");
		jplQuery.setParameter("datoNombre", nombre);
		return  (Estudiante) jplQuery.getResultList().get(0);
	}

	@Override
	public List<Estudiante> buscarPorNombreNamedQueryList(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estudiante> buscarPorNombreNativeQueryTypedNamedList(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public EstudianteDTO buscarPorNombreTypedQueryDTO(String nombre) {
		TypedQuery<EstudianteDTO> myTypedQuery = this.entityManager.createQuery(
				"select NEW EstudianteDTO(e.nombre,e.apellido,e.cedula) from Estudiante e where e.nombre = :datoNombre", EstudianteDTO.class);
		myTypedQuery.setParameter("datoNombre", nombre);
		return myTypedQuery.getSingleResult();
	}
}
