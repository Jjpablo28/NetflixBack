package co.edu.unbosque.miprimerspingboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiante")


public class Estudiante {// clase entidad
	
	private @Id @GeneratedValue (strategy = GenerationType.IDENTITY) Integer id;
		
	private String nombre;
	@Column(name = "documentoestudiante",unique = true)
	private int documento;
	private String programa;
	private int semestre;

	public Estudiante() {
		// TODO Auto-generated constructor stub
	}

	public Estudiante(String nombre, int documento, String programa, int semestre) {
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
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", documento=" + documento + ", programa=" + programa
				+ ", semestre=" + semestre + "]";
	}



}
