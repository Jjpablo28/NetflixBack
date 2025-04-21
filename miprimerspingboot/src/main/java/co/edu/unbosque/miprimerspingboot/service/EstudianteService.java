package co.edu.unbosque.miprimerspingboot.service;

import co.edu.unbosque.miprimerspingboot.dto.EstudianteDTO;
import co.edu.unbosque.miprimerspingboot.model.Estudiante;
import co.edu.unbosque.miprimerspingboot.repository.EstudianteRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteService { // Model facade
  // Funciones de servicio - se utiliza el repositorio y toda fuente externa

  @Autowired private EstudianteRepository estudianteRepo;
  @Autowired private ModelMapper modelMapper;

  public EstudianteService() {
    // TODO Auto-generated constructor stub
  }

  public int create(EstudianteDTO data) {
    Estudiante entity = modelMapper.map(data, Estudiante.class);
    try {
      estudianteRepo.save(entity);
      return 0;
    } catch (Exception e) { // sql exception
      return 1;
    }
  }

  public ArrayList<EstudianteDTO> findAll() {
    ArrayList<Estudiante> entityList = (ArrayList<Estudiante>) estudianteRepo.findAll();
    ArrayList<EstudianteDTO> dtoList = new ArrayList<>();
    entityList.forEach(
        (entity) -> {
          EstudianteDTO dto = modelMapper.map(entity, EstudianteDTO.class);
          dtoList.add(dto);
        });
    return dtoList;
  }

  public int deleteById(Integer id) {
    Optional<Estudiante> found = estudianteRepo.findById(id);
    if (found.isPresent()) {
      estudianteRepo.delete(found.get());
      return 0;
    } else {
      return 1;
    }
  }
}
