package co.edu.unbosque.miprimerspingboot.service;

import co.edu.unbosque.miprimerspingboot.dto.ProductoDTO;
import co.edu.unbosque.miprimerspingboot.model.Producto;
import co.edu.unbosque.miprimerspingboot.repository.ProductoRepository;
import java.util.ArrayList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

  @Autowired private ProductoRepository productoRepo;
  @Autowired private ModelMapper modelMapper;

  public int create(ProductoDTO data) {
    Producto entity = modelMapper.map(data, Producto.class);
    try {
      productoRepo.save(entity);
      return 0;
    } catch (Exception e) { // sql exception
      return 1;
    }
  }

  public ArrayList<ProductoDTO> findAll() {
    ArrayList<Producto> entityList = (ArrayList<Producto>) productoRepo.findAll();
    ArrayList<ProductoDTO> dtoList = new ArrayList<>();
    entityList.forEach(
        (entity) -> {
          ProductoDTO dto = modelMapper.map(entity, ProductoDTO.class);
          dtoList.add(dto);
        });
    return dtoList;
  }
}
