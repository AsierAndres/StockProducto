package org.sistema.springmvc.forms.dtos;


/**
 * Represents a Producto.
 * 
 * @author Eugenia Pérez Martínez
 *
 */
public class ProductoDTO {
	//@Pattern(regexp = "[0-9]+", message = "Must contain only numbers")
	//@Size(min=1, message = "Minimun size is 1")
	private int id;
	
	//@NotNull(message = "The name is required")
	//@Pattern(regexp = "[A-Za-z]+", message = "Must contain only chars")
	private String name;
	

	//@NotNull(message = "The description is required")
	//@Pattern(regexp = "[A-Za-z]+", message = "Must contain only chars")
	private String description;
	
	//@Size(min=0D, message ="Minimun size is 0")
	private float pvp;
	//Adding new fields

	//@Pattern(regexp = "[0-9]+", message = "Must contain only numbers")
	//@Size(min=1, message = "Minimun size is 1")
	private int stockId;
	
	private int stockEstanteria;
	
	/**
	 * default constructor
	 */
	public ProductoDTO () {
		
	}
	
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param stock
	 */
	public ProductoDTO(int id, String name, String description, float pvp, int stockId, int stockEstanteria) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.pvp = pvp;
		this.stockId = stockId;
		this.stockEstanteria = stockEstanteria;
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
	 * @param pvp the pvp to set
	 */
	public void setPvp(float pvp) {
		this.pvp = pvp;
	}
	
	/**
	 * @return the pvp
	 */
	public float getPvp() {
		return pvp;
	}
	
	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public int getstockEstanteria() {
		return stockEstanteria;
	}

	public void setstockEstanteria(int stockEstanteria) {
		this.stockEstanteria = stockEstanteria;
	}


	
	

}
