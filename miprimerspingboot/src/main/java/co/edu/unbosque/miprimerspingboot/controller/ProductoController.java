package co.edu.unbosque.miprimerspingboot.controller;

import co.edu.unbosque.miprimerspingboot.dto.ProductoDTO;
import co.edu.unbosque.miprimerspingboot.service.ProductoService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = {"*"})
public class ProductoController {

  @Autowired private ProductoService productoSer;

  public ProductoController() {
    // TODO Auto-generated constructor stub
  }

  @PostMapping("/crear")
  public ResponseEntity<String> crear(
      @RequestParam String nombre,
      @RequestParam String marca,
      @RequestParam double precio,
      @RequestParam int cant) {

    ProductoDTO nuevoProducto = new ProductoDTO(nombre, marca, precio, cant);
    int estado = productoSer.create(nuevoProducto);

    if (estado == 0) {
      return new ResponseEntity<>("Producto creado con exito", HttpStatus.CREATED);

    } else {
      return new ResponseEntity<>("Error al crear el Producto", HttpStatus.NOT_ACCEPTABLE);
    }
  }

  @GetMapping("/mostrarTodo")
  public ResponseEntity<ArrayList<ProductoDTO>> mostrarTodo() {
    ArrayList<ProductoDTO> productos = productoSer.findAll();
    if (productos.isEmpty()) {
      return new ResponseEntity<ArrayList<ProductoDTO>>(productos, HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<ArrayList<ProductoDTO>>(productos, HttpStatus.ACCEPTED);
    }
  }
}
