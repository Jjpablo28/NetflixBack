package co.edu.unbosque.miprimerspingboot.dto;

public class ProductoDTO {

	private int id;

	private String nombre;
	private String marca;
	private double costo;
	private int cantidad;

	public ProductoDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductoDTO(String nombre, String marca, double costo, int cantidad) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.costo = costo;
		this.cantidad = cantidad;
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

}