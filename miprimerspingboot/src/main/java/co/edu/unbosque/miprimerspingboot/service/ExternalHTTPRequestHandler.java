package co.edu.unbosque.miprimerspingboot.service;

import co.edu.unbosque.miprimerspingboot.dto.FactDTO;
import co.edu.unbosque.miprimerspingboot.dto.HumorDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ExternalHTTPRequestHandler {
  private static final HttpClient HTTP_CLIENT =
      HttpClient.newBuilder()
          .version(HttpClient.Version.HTTP_2)
          .connectTimeout(Duration.ofSeconds(10))
          .build();

  public static void main(String[] args) throws IOException, InterruptedException {

    String url = "https://uselessfacts.jsph.pl/api/v2/facts/random";
    FactDTO hecho = doGetAndConvertToDTO(url);
    System.out.println(hecho.toString());
  }

  public static String doGetAndParse(String url) {
    HttpRequest request =
        HttpRequest.newBuilder()
            .GET()
            .uri(URI.create(url))
            .header("Content-type", "application/json")
            .build();
    HttpResponse<String> response = null;
    try {
      response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("status code -> " + response.statusCode());
    String uglyJsonString = response.body();
    return prettyPrintUsingGson(uglyJsonString);
  }

  private static String prettyPrintUsingGson(String uglyJsonString) {
    Gson gson = new GsonBuilder().setLenient().setPrettyPrinting().create();
    JsonElement jsonElement = JsonParser.parseString(uglyJsonString);
    String prettyJsonString = gson.toJson(jsonElement);

    return prettyJsonString;
  }

  public static FactDTO doGetAndConvertToDTO(String url) {

    HttpRequest request =
        HttpRequest.newBuilder()
            .GET()
            .uri(URI.create(url))
            .header("Content-type", "application/json")
            .build();
    HttpResponse<String> response = null;
    try {
      response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    String json = response.body();
    FactDTO fact = new GsonBuilder().create().fromJson(json, FactDTO.class);
    return fact;
  }

  public static HumorDTO doGetAndConvertToDTOHumor(String url) {

    HttpRequest request =
        HttpRequest.newBuilder()
            .GET()
            .uri(URI.create(url))
            .header("Content-type", "application/json")
            .build();
    HttpResponse<String> response = null;
    try {
      response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    String json = response.body();
    HumorDTO joke = new GsonBuilder().create().fromJson(json, HumorDTO.class);
    return joke;
  }
}
