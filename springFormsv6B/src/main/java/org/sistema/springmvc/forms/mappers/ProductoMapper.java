package org.sistema.springmvc.forms.mappers;

import org.sistema.springmvc.forms.dtos.ProductoDTO;
import org.sistema.springmvc.forms.models.Producto;
import org.sistema.springmvc.forms.models.Stock;

public class ProductoMapper {

	public static Producto toProducto(ProductoDTO productoDTO, Stock stock) {
		Producto producto = new Producto();
		producto.setId(productoDTO.getId());
		producto.setDescription(productoDTO.getDescription());
		producto.setPvp(productoDTO.getPvp());
		producto.setName(productoDTO.getName());
		producto.setStock(stock);
		return producto;
	}

	public static ProductoDTO toDTO(Producto producto) {
		ProductoDTO productoDTO = new ProductoDTO(producto.getId(), producto.getName(),
				producto.getDescription(), producto.getPvp(), producto.getStock().getId(), producto.getStock()
						.getEstanteria());
		return productoDTO;
	}

}
