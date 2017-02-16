package org.sistema.springmvc.forms.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Represents a Producto.
 * 
 * @author Eugenia Pérez Martínez
 *
 */

@Entity
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	@NotNull(message = "The name is required")
	@Pattern(regexp = "[A-Za-z]+", message = "Must contain only chars")
	private String name;

	@NotNull(message = "The description is required")
	@Pattern(regexp = "[A-Za-z]+", message = "Must contain only chars")
	private String description;
	


	@Digits(integer=6, fraction = 2, message = "Float please")
	private float pvp;
	
	@ManyToOne
	private Stock stock;
	
	/**
	 * default constructor
	 */
	public Producto () {
		
	}
	
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param stock
	 */
	public Producto(int id, String name, String description, float pvp, Stock stock) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.pvp = pvp;
		this.stock = stock;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return the pvp
	 */
	public float getPvp() {
		return pvp;
	}

	/**
	 * @param pvp the pvp to set
	 */
	public void setPvp(float pvp) {
		this.pvp = pvp;
	}
	
	/**
	 * @return the stock
	 */
	public Stock getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(Stock stock) {
		this.stock = stock;
	}

	

}
