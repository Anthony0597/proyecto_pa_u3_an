package com.example.demo.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.dialect.MyISAMStorageEngine;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Estudiante;
import com.example.demo.modelo.dto.EstudianteDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
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
				"select NEW com.example.demo.modelo.dto.EstudianteDTO(e.nombre,e.apellido,e.cedula) from Estudiante e where e.nombre = :datoNombre", EstudianteDTO.class);
		myTypedQuery.setParameter("datoNombre", nombre);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public Estudiante buscarPorNombreCriteria(String nombre) {
		CriteriaBuilder myBuilder=this.entityManager.getCriteriaBuilder();
		//Especificamos el tio de retorno del query
		CriteriaQuery<Estudiante> myQuery = myBuilder.createQuery(Estudiante.class);
		
		//Aquí empezamos a crear el sql como tal
		//Definimos el From que es la tabla de donde tomamos los datos, se lo toma como el principal o root FROM-Root
		Root<Estudiante> miTablaFrom = myQuery.from(Estudiante.class);
		
		//Las condiciones where se conocen en criteria APIcomo predicados
		//e.nombre 0 :datoNombre
		Predicate condicion1 = myBuilder.equal(miTablaFrom.get("nombre"), nombre);
		
		myQuery.select(miTablaFrom).where(condicion1);
		
		//La ejecucion del query lo realizamos con cualquier tipo ya conocido, recomendacion typedQuery
		TypedQuery<Estudiante> mySQl = this.entityManager.createQuery(myQuery);
		
		return mySQl.getSingleResult();
	}

	@Override
	public List<Estudiante> buscarPorNombreCriteriaAndOR(String nombre, String apellido, String bandera) {
		CriteriaBuilder myBuilder=this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Estudiante> myQuery = myBuilder.createQuery(Estudiante.class);
		Root<Estudiante> miTablaFrom = myQuery.from(Estudiante.class);
		//M: e.nombre= AND e.apellido=
		//F: e.nombre= OR e.apellido=
		//Creamos los predicados
		//Predicado del nombre
		Predicate p1 = myBuilder.equal(miTablaFrom.get("nombre"), nombre);
		//Predicado del apellido
		Predicate p2 = myBuilder.equal(miTablaFrom.get("apellido"), apellido);
		
		Predicate predicadoFinal= null;
		if(bandera.equals("M")) {
			//Predicado del AND
			predicadoFinal =myBuilder.and(p1,p2);
		}else {
			//Predicado del AND
			predicadoFinal =myBuilder.or(p1,p2);
		}
		
		
		myQuery.select(miTablaFrom).where(predicadoFinal);
		
		//La ejecucion del query lo realizamos con cualquier tipo ya conocido, recomendacion typedQuery
		TypedQuery<Estudiante> mySQl = this.entityManager.createQuery(myQuery);
		
		return mySQl.getResultList();
	}

	@Override
	public int eliminarPorApellido(String apellido) {
		//DELETE FROM estudiante WHERE estu_apellido = 'Teran'
		Query query = this.entityManager.createQuery(
				"DELETE From Estudiante e WHERE e.apellido = :apellido");
		query.setParameter("apellido",apellido);
		
		return query.executeUpdate();
	}

	@Override
	public int actualizarPorApellido(String apellido, String nombre) {
		//UPDATE estudiante SET estu_nombre = 'Edison' WHERE estu_apellido = 'Cayambe'
		Query query = this.entityManager.createQuery(
				"UPDATE Estudiante e SET e.nombre = :datoNombre WHERE e.apellido = :apellido");
		query.setParameter("datoNombre",nombre);
		query.setParameter("apellido",apellido);
		
		return query.executeUpdate();
	}
}
