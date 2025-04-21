package co.edu.unbosque.miprimerspingboot.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.miprimerspingboot.dto.EstudianteDTO;
import co.edu.unbosque.miprimerspingboot.service.EstudianteService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/estudiante")
@CrossOrigin(origins = { "*" })

public class EstudianteController {
//El controller llama al service, y el service llama al repository

	@Autowired
	private EstudianteService estudianteServ;

	public EstudianteController() {
		// TODO Auto-generated constructor stub
	}

	@PostMapping("/crear")
	public ResponseEntity<String> crear(@RequestParam String nombre, @RequestParam int doc,
			@RequestParam String programa, @RequestParam int semestre) {

		EstudianteDTO nuevoEstudiante = new EstudianteDTO(nombre, doc, programa, semestre);
		int estado = estudianteServ.create(nuevoEstudiante);

		if (estado == 0) {
			return new ResponseEntity<>("Estudiante creado con exito", HttpStatus.CREATED);

		} else {
			return new ResponseEntity<>("Error al crear el estudiante", HttpStatus.NOT_ACCEPTABLE);

		}

	}

	@GetMapping("/mostrarTodo")
	public ResponseEntity<ArrayList<EstudianteDTO>> mostrarTodo() {
		ArrayList<EstudianteDTO> estudiantes = estudianteServ.findAll();
		if (estudiantes.isEmpty()) {
			return new ResponseEntity<ArrayList<EstudianteDTO>>(estudiantes, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<ArrayList<EstudianteDTO>>(estudiantes, HttpStatus.ACCEPTED);

		}
	}

	@DeleteMapping("/eliminarPorId/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id) {
		int status = estudianteServ.deleteById(id);
		if (status == 0) {
			return new ResponseEntity<>("Estudiante eliminado con exito", HttpStatus.ACCEPTED);

		} else {
			return new ResponseEntity<>("Error al eliminar estudiante", HttpStatus.NOT_FOUND);
		}

	}

}
