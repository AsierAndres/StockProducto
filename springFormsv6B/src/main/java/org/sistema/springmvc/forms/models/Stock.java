package org.sistema.springmvc.forms.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Represents a stock.
 * 
 * @author Eugenia Pérez Martínez
 *
 */
@Entity
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Digits(integer=6, fraction = 0, message = "Integer please")
	private int estanteria;
	
	@NotNull(message = "The name is required")
	@Pattern(regexp = "[A-Za-z]+", message = "Must contain only chars.")
	private String description;
	
	@Digits(integer=6, fraction = 0, message = "Integer please")
	private int cantidad;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy ="stock")
	private Set<Producto> productos = new HashSet<Producto>();

	/**
	 * default constructor
	 */
	public Stock() {
	}

	/**
	 * constructor with parameters
	 * @param id
	 * @param estanteria
	 * @param description
	 * @param cantidad
	 */
	public Stock(int id, int estanteria, String description, int cantidad) {
		this.id = id;
		this.estanteria = estanteria;
		this.description = description;
		this.cantidad = cantidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEstanteria() {
		return estanteria;
	}

	public void setEstanteria(int estanteria) {
		this.estanteria = estanteria;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the productos
	 */
	public Set<Producto> getProductos() {
		return productos;
	}

	/**
	 * @param productos the productos to set
	 */
	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}
	
	/**
	 * 
	 * @param producto
	 */
	public void addProducto(Producto producto){
		this.productos.add(producto);
		producto.setStock(this);
	}

}
