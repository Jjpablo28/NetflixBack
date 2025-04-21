package co.edu.unbosque.miprimerspingboot.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.miprimerspingboot.dto.FactDTO;
import co.edu.unbosque.miprimerspingboot.service.FactService;

@RestController
@RequestMapping("/fact")
@CrossOrigin(origins = { "*" })
public class FactController {

	@Autowired
	private FactService factService;

	public FactController() {

	}

	@GetMapping("/solicitar")
	public ResponseEntity<FactDTO> solicitarUnDato() {
		return new ResponseEntity<FactDTO>(factService.obtenerUnDatoRandom(), HttpStatus.ACCEPTED);
	}

	@GetMapping("/solicitarvarios")
	public ResponseEntity<ArrayList<FactDTO>> getMethodName() {
		ArrayList<FactDTO>factList=new ArrayList<>();
		for (int i = 0; i <5; i++) {
			factList.add(factService.obtenerUnDatoRandom());
		}
		return new ResponseEntity<>(factList, HttpStatus.ACCEPTED);
	}

}
