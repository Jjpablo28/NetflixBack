package co.edu.unbosque.miprimerspingboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.miprimerspingboot.model.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {

	List<Producto> findByNombre(String nombre);
	
	void deleteByNombre(String nombre);
	
	
	
}
