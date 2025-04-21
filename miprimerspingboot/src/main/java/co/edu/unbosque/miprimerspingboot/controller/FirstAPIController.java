package co.edu.unbosque.miprimerspingboot.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@CrossOrigin(origins = {"*"})
@Transactional
public class FirstAPIController {

  @GetMapping("/saludar")
  public String saludar(@RequestParam String nombre) {
    return "buenos dias " + nombre;
  }

  @GetMapping("/volumenCilindro")
  public String calcularVolumenCilindro(@RequestParam int radio, int altura) {
    return "El volumen es:" + (Math.PI * (Math.pow(radio, 2)) * altura);
  }

  @GetMapping("/volumenEsfera")
  public String calcularVolumenEsfera(@RequestParam int radio) {
    return "El volumen de la esfera es: " + ((4.0 / 3.0) * (Math.PI) * Math.pow(radio, 3));
  }

  @GetMapping("/volumenDodecaedro")
  public String calcularVolumenDodecaedro(@RequestParam int arista) {
    return "El volumen del dodecaedro es: " + ((15 + 7 * Math.sqrt(5)) / 4) * Math.pow(arista, 3);
  }

  @GetMapping("/contarVocales")
  public String contarVocales(@RequestParam String palabra) {

    int vocales = 0;

    for (int i = 0; i < palabra.length(); i++) {
      char c = palabra.toLowerCase().charAt(i);
      if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
        vocales++;
      }
    }

    return "Cantidad de vocales: " + vocales;
  }

  @GetMapping("/contarX")
  public String contarX(@RequestParam String palabra) {

    int vocales = 0;

    for (int i = 0; i < palabra.length(); i++) {
      char c = palabra.toLowerCase().charAt(i);
      if (c == 'x') {
        vocales++;
      }
    }

    return "Cantidad de 'X' en la palabra: " + vocales;
  }

  @GetMapping("/verificarEspacios")
  public String verificarEspacios(@RequestParam String text) {
    int espacios = 0;

    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      if (c == ' ') {
        espacios++;
      }
    }

    return "Cantidad de espacios en la palabra: " + espacios;
  }

  @GetMapping("/verificarCorreo")
  public String verificarCorreo(@RequestParam String email) {
    String regex =
        "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(email);
    String respuesta = "";

    if (matcher.matches() == true) {

      respuesta = "si";
    } else {
      respuesta = "no";
    }

    return "El correo " + respuesta + " es valido";
  }

  @GetMapping("/verificarPais")
  public String verificarPais(@RequestParam String pais) {
    String res = "no";
    String[] paises = Locale.getISOCountries();

    for (String codigoPais : paises) {
      Locale locale = new Locale("", codigoPais);
      if (locale.getDisplayCountry().equalsIgnoreCase(pais)) {
        res = "si";
        break;
      }
    }

    return "El pais " + pais + " " + res + " existe";
  }

  @GetMapping("/verificarGroserias")
  public String verificarGroserias(@RequestParam String text) {

    String p = "no";

    List<String> diccionarioGroserias =
        Arrays.asList(
            "arrechos",
            "boletos",
            "cabrón",
            "caca",
            "cacorro",
            "calanchín",
            "calanchines",
            "carechimba",
            "caremondá",
            "caremondás",
            "careverga",
            "carevergas",
            "carajo",
            "carirrotos",
            "casposo",
            "casposos",
            "chanda",
            "chandas",
            "chiflado",
            "chimbada",
            "chimbadas",
            "chucha",
            "chucha",
            "chuchas",
            "culicagado",
            "culicagados",
            "culón",
            "culones",
            "cagones",
            "come mierdas",
            "cochinas",
            "concha",
            "concha de tu madre",
            "coño",
            "coprofagía",
            "coprolagnia",
            "descerebrado",
            "ejaculación",
            "erotismo",
            "escort",
            "estirado",
            "estirados",
            "estúpido",
            "fracasado",
            "gamines",
            "gonorrea",
            "gonorreas",
            "gorrero",
            "gorreros",
            "guiso",
            "guisos",
            "güevones",
            "guevonadas",
            "hacer una paja",
            "haciendo el amor",
            "heroína",
            "hijaputa",
            "hija de puta",
            "hijoputa",
            "hijoputas",
            "hijuemadre",
            "hijuemadres",
            "hijuelagranputa",
            "hijuelagranputas",
            "hijueperra",
            "hijueperras",
            "hijueputa",
            "hijueputas",
            "hijuegranputa",
            "hijuegranputas",
            "hijo de puta",
            "idiota",
            "imbécil",
            "incesto",
            "infierno",
            "jilipollas",
            "lagarto",
            "lagartos",
            "lameculos",
            "lambones",
            "maciza",
            "macizorra",
            "maldito",
            "malparideces",
            "malparidez",
            "malparidito",
            "malparido",
            "malparidos",
            "mamerto",
            "mamón",
            "mamones",
            "marica",
            "maricas",
            "maricón",
            "maricones",
            "mariconazo",
            "martillo",
            "mechudo",
            "mechudos",
            "mequetrefe",
            "mierda",
            "mierdero",
            "mierdoso",
            "mochos",
            "monda",
            "mondas",
            "pajudos",
            "perra",
            "perras",
            "perrero",
            "perreros",
            "pichón",
            "pichones",
            "pichurria",
            "pichurrias",
            "pimiento",
            "pingo",
            "pinche",
            "pinche idiota",
            "pis",
            "pirobos",
            "playos",
            "playudos",
            "prostituta",
            "ramera",
            "rascabuches",
            "rectum",
            "sádico",
            "sadismo",
            "sapos",
            "sarnosos",
            "semen",
            "suicidio",
            "su merced hijueputas",
            "tirapiedras",
            "vete a la mierda",
            "zorras",
            "zungas",
            "abejorro",
            "amargado",
            "anormal",
            "arrastrado",
            "atarván",
            "baboso",
            "barrigón",
            "bestia",
            "bruto",
            "cabeza de chorlito",
            "cabeza hueca",
            "cafre",
            "cagada",
            "cagón",
            "calumniador",
            "caradura",
            "caremonda",
            "carepalo",
            "careperro",
            "caretabla",
            "chabacano",
            "chanchullero",
            "chatarra",
            "chismoso",
            "chivo loco",
            "chúcaro",
            "chupamedias",
            "desalmado",
            "descarado",
            "desdichado",
            "desocupado",
            "desquiciado",
            "embaucador",
            "engendro",
            "escoria",
            "estafador",
            "farsante",
            "fastidioso",
            "flojo",
            "fuchi",
            "fulero",
            "gandul",
            "granuja",
            "holgazán",
            "inútil",
            "llorón",
            "majadero",
            "malandrín",
            "malhablado",
            "malintencionado",
            "malnacido",
            "mamerto",
            "manganzón",
            "mequetrefe",
            "metiche",
            "miserable",
            "mitómano",
            "mugroso",
            "naco",
            "nefasto",
            "ñero",
            "odioso",
            "ordinario",
            "papanatas",
            "patán",
            "patuleco",
            "payaso",
            "pelmazo",
            "pelele",
            "perdedor",
            "petardo",
            "piltrafa",
            "pingo",
            "pipiolo",
            "podrido",
            "presuntuoso",
            "pueblerino",
            "rata",
            "ridículo",
            "ruin",
            "sanguijuela",
            "sapo",
            "sinvergüenza",
            "tarado",
            "tonto",
            "torpe",
            "tramposo",
            "trepador",
            "truhan",
            "turbio",
            "vago",
            "vaquetón",
            "veneco",
            "vividor",
            "zopenco",
            "zángano",
            "Airhead",
            "Asshat",
            "Backstabber",
            "Bastard",
            "Bigmouth",
            "Birdbrain",
            "Blockhead",
            "Bonehead",
            "Bullshit",
            "Cheapskate",
            "Clown",
            "Cocky",
            "Crook",
            "Deadbeat",
            "Dimwit",
            "Dirtbag",
            "Dishonest",
            "Dumbass",
            "Dunce",
            "Fatso",
            "Fool",
            "Freak",
            "Garbage",
            "Goofball",
            "Halfwit",
            "Idiot",
            "Ignoramus",
            "Jackass",
            "Jerk",
            "Killjoy",
            "Knucklehead",
            "Lazybones",
            "Liar",
            "Loser",
            "Lowlife",
            "Lunatic",
            "Menace",
            "Moron",
            "Nitwit",
            "Numbskull",
            "Nuisance",
            "Oaf",
            "Peabrain",
            "Pest",
            "Phony",
            "Punk",
            "Rascal",
            "Rotten",
            "Scumbag",
            "Scoundrel",
            "Shameless",
            "Slanderous",
            "Slimy",
            "Sloppy",
            "Sore loser",
            "Stingy",
            "Stinker",
            "Stupid",
            "Sucker",
            "Trash",
            "Troublemaker",
            "Twit",
            "Tyrant",
            "Ungrateful",
            "Wacko",
            "Weasel",
            "Whiner",
            "Wimp",
            "Worthless",
            "Yapper",
            "Zero");

    for (String groseria : diccionarioGroserias) {
      if (text.toLowerCase().contains(groseria.toLowerCase())) {

        p = "si";

        break;
      }
    }

    return "El texto " + var + " contiene groserias";
  }
}
