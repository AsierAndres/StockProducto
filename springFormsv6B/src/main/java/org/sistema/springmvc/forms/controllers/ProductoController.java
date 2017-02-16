package org.sistema.springmvc.forms.controllers;

import java.util.Map;

import org.sistema.springmvc.forms.dao.ProductoDAO;
import org.sistema.springmvc.forms.dao.StockDAO;
import org.sistema.springmvc.forms.models.Producto;
import org.sistema.springmvc.forms.models.Stock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for stocks.
 * 
 * @author Eugenia Pérez Martínez
 *
 */
@Controller
public class ProductoController {
	private static final Logger logger = LoggerFactory
			.getLogger(ProductoController.class);

	@Autowired
	private ProductoDAO productoDAO;

	@Autowired
	private StockDAO stockDAO;

	/**
	 * handles /productos/id
	 * 
	 * @param model
	 * @return the name of the view to show RequestMapping({"/stocks/{id}"})
	 */
	@RequestMapping(method = RequestMethod.GET, value = { "/productos/{id}" })
	public String stockProductoDetail(@PathVariable(value = "id") Integer id,
			Map<String, Object> model) {
		logger.info("Stock producto detail");

		Producto producto = productoDAO.selectById(id, Producto.class);
		model.put("producto", producto);

		return "producto/productoDetail";
	}

	/**
	 * handles /stocks/producto/new by POST
	 * 
	 * @return the name of the view to show RequestMapping({"/stocks/new"})
	 */
	@RequestMapping(method = RequestMethod.POST, value = { "/productos/new" })
	public ModelAndView createProducto(Producto producto) {

		ModelAndView modelAndView = new ModelAndView();

		if (productoDAO.insert(producto)) {
			// We return view name
			modelAndView.setViewName("producto/created");
			modelAndView.addObject("producto", producto);
			logger.info("Saveview POST " + producto.getId());
		} else {
			modelAndView.setViewName("error");
			modelAndView
					.addObject(
							"error",
							"An error ocurred while trying to create a new producto for stock. Please, try again");
		}
		return modelAndView;
	}

	/**
	 * Simply selects the update view for productos
	 */
	@RequestMapping(value = "/productos/update/{id}", method = RequestMethod.GET)
	public String updateProducto(@PathVariable(value = "id") Integer productoId,
			Model model) {
		logger.info("Showing update producto view GET ");

		Producto producto = productoDAO.selectById(productoId, Producto.class);
		
		model.addAttribute("producto", producto);
		model.addAttribute("stocks", stockDAO.selectAll(Stock.class));

		return "producto/update";
	}

	/**
	 * Handles the POST from the Custom.jsp page to update the Stock.
	 */
	@RequestMapping(value = "/productos/saveupdate", method = RequestMethod.POST)
	public ModelAndView saveUpdateProducto(Producto producto) {
		logger.info("Save update producto " + producto.getId());
		
		productoDAO.update(producto);

		ModelAndView modelAndView = new ModelAndView();

		// We pass the stock received through this object
		modelAndView.addObject("producto", producto);

		// The same as return "stock/saveUpdate"
		modelAndView.setViewName("producto/saveUpdated");
		return modelAndView;
	}

	/**
	 * Delete the specific producto
	 */
	@RequestMapping(value = "/productos/delete/{id}", method = RequestMethod.GET)
	public String deleteProducto(@PathVariable(value = "id") Integer productoId,
			Model model) {
		logger.info("Stock detail /delete producto: " + productoId);

		// Store the concrete producto to send it back before deleting to use it in
		// the following view.
		Producto producto = productoDAO.selectById(productoId, Producto.class);
		model.addAttribute("producto", producto);

		productoDAO.delete(producto);

		return "producto/deleted";
	}

}
