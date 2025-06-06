package co.edu.unbosque.miprimerspingboot.dto;

public class EstudianteDTO { // Entidad solo para el back
  // Objeto para mover entre capas - Realizar operaciones

  private Integer id;
  private String nombre;
  private int documento;
  private String programa;
  private int semestre;

  public EstudianteDTO() {
    // TODO Auto-generated constructor stub
  }

  public EstudianteDTO(String nombre, int documento, String programa, int semestre) {
    super();
    this.nombre = nombre;
    this.documento = documento;
    this.programa = programa;
    this.semestre = semestre;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getDocumento() {
    return documento;
  }

  public void setDocumento(int documento) {
    this.documento = documento;
  }

  public String getPrograma() {
    return programa;
  }

  public void setPrograma(String programa) {
    this.programa = programa;
  }

  public int getSemestre() {
    return semestre;
  }

  public void setSemestre(int semestre) {
    this.semestre = semestre;
  }

  @Override
  public String toString() {
    return "EstudianteDTO [id="
        + id
        + ", nombre="
        + nombre
        + ", documento="
        + documento
        + ", programa="
        + programa
        + ", semestre="
        + semestre
        + "]";
  }
}
