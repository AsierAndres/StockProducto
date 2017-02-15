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
	private int estanteria;
	private String description;
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
