package co.edu.unbosque.miprimerspingboot.service;


import java.util.ArrayList;


import org.springframework.stereotype.Service;

import co.edu.unbosque.miprimerspingboot.dto.FactDTO;

@Service
public class FactService {
	private final String URL = "https://uselessfacts.jsph.pl/api/v2/facts/random";
	
	public FactService() {
		// TODO Auto-generated constructor stub
	}

	public FactDTO obtenerUnDatoRandom() {

		return ExternalHTTPRequestHandler.doGetAndConvertToDTO(URL);

	}
	
	public ArrayList<FactDTO>obtenerVariosDatos(){
		ArrayList<FactDTO>factList=new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			factList.add(ExternalHTTPRequestHandler.doGetAndConvertToDTO(URL));
		}
		return factList;
	}
	
}
