package co.edu.unbosque.miprimerspingboot.service;

import co.edu.unbosque.miprimerspingboot.dto.HumorDTO;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class HumorService {
  private final String URL =
      "https://api.humorapi.com/jokes/random?api-key=d66bcee9830845198bee32c5c30e7811";

  public HumorService() {
    // TODO Auto-generated constructor stub
  }

  public HumorDTO obtenerUnChisteRandom() {

    return ExternalHTTPRequestHandler.doGetAndConvertToDTOHumor(URL);
  }

  public ArrayList<HumorDTO> obtenerCincoDatos() {
    ArrayList<HumorDTO> jokeList = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      jokeList.add(ExternalHTTPRequestHandler.doGetAndConvertToDTOHumor(URL));
    }
    return jokeList;
  }

  public ArrayList<HumorDTO> obtenerDiezDatos() {
    ArrayList<HumorDTO> jokeList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      jokeList.add(ExternalHTTPRequestHandler.doGetAndConvertToDTOHumor(URL));
    }
    return jokeList;
  }
}
