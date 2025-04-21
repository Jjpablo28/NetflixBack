package co.edu.unbosque.miprimerspingboot.repository;

import co.edu.unbosque.miprimerspingboot.model.Producto;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {

  List<Producto> findByNombre(String nombre);

  void deleteByNombre(String nombre);
}
