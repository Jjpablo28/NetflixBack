package co.edu.unbosque.miprimerspingboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.miprimerspingboot.model.Estudiante;

public interface EstudianteRepository extends CrudRepository<Estudiante, Integer> {

	List<Estudiante> findByNombre(String nombre);
	
	void deleteByNombre(String nombre);
	
	
	
	
}
