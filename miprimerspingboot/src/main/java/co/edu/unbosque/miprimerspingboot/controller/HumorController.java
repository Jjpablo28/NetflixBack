package co.edu.unbosque.miprimerspingboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.miprimerspingboot.dto.HumorDTO;
import co.edu.unbosque.miprimerspingboot.service.HumorService;

@RestController
@RequestMapping("/chiste")
@CrossOrigin(origins = { "*" })
public class HumorController {
	@Autowired
	private HumorService humorService;

	public HumorController() {
	}

	@GetMapping("/solicitaruno")
	public ResponseEntity<HumorDTO> solicitarChiste() {
		return new ResponseEntity<HumorDTO>(humorService.obtenerUnChisteRandom(), HttpStatus.ACCEPTED);
	}
	
	
	

}
