package co.edu.unbosque.miprimerspingboot.repository;

import co.edu.unbosque.miprimerspingboot.model.Estudiante;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface EstudianteRepository extends CrudRepository<Estudiante, Integer> {

  List<Estudiante> findByNombre(String nombre);

  void deleteByNombre(String nombre);
}
