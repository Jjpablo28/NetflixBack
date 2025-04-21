package co.edu.unbosque.miprimerspingboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")

public class Producto {

	private @Id @GeneratedValue (strategy = GenerationType.IDENTITY) Integer id;


	private String nombre;
	private String marca;
	private double costo;
	private int cantidad;



	public Producto( String nombre, String marca, double costo, int cantidad) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.costo = costo;
		this.cantidad = cantidad;
	}

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

}
