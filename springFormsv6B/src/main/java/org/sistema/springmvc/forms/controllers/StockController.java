package org.sistema.springmvc.forms.controllers;

import java.util.List;
import java.util.Map;

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
public class StockController {
	private static final Logger logger = LoggerFactory
			.getLogger(StockController.class);

	@Autowired
	private StockDAO stockDAO;


	/**
	 * handles default /stocks
	 * 
	 * @param model
	 * @return the name of the view to show RequestMapping({"/stocks"})
	 */

	@RequestMapping(method = RequestMethod.GET, value = { "/", "/stocks" })
	public String showStocks(Map<String, Object> model) {
		logger.info("Stock showStocks. ");

		
		List<Stock> stocks = stockDAO.selectAll(Stock.class);
		model.put("stocks", stocks);

		return "stock/stocks";
	}

	/**
	 * handles default /stocks/id
	 * 
	 * @param model
	 * @return the name of the view to show RequestMapping({"/stocks/{id}"})
	 */
	@RequestMapping(method = RequestMethod.GET, value = { "/stocks/{id}" })
	public String stockDetail(@PathVariable(value = "id") Integer id,
			Map<String, Object> model) {
		logger.info("Stock detail");

		Stock stock = stockDAO.selectById(id, Stock.class);
		//The stock gets his own collection of productos load
		model.put("stock", stock);
		
		// We add producto for the new producto form
		Producto producto = new Producto();
		producto.setStock(stock);
		model.put("producto", producto);

		return "stock/stockDetail";
	}
	
	
	/**
	 * handles /stocks/new by GET
	 * 
	 * @return the name of the view to show RequestMapping({"/stocks/new"})
	 */
	@RequestMapping(method = RequestMethod.GET, value = { "/stocks/new" })
	public String newStock(Map<String, Object> model) {
		logger.info("Showing custom view GET ");

		model.put("stock", new Stock());

		return "stock/newStock";
	}

	/**
	 * handles /stocks/new by POST
	 * 
	 * @return the name of the view to show RequestMapping({"/stocks/new"})
	 */
	@RequestMapping(method = RequestMethod.POST, value = { "/stocks/new" })
	public ModelAndView createStock(Stock stock) {
		logger.info("Saveview POST " + stock.getId());

		ModelAndView modelAndView = new ModelAndView();

		if (stockDAO.insert(stock)) {
			// We return view name
			modelAndView.setViewName("stock/created");
			modelAndView.addObject("stock", stock);
		} else {
			modelAndView.setViewName("error");
			modelAndView
					.addObject("error",
							"An error ocurred while trying to create a new stock. Please, try again");
		}
		return modelAndView;
	}

	
	
	
	/**
	 * Simply selects the update view
	 */
	@RequestMapping(value = "/stocks/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable(value = "id") Integer stockId, Model model) {
		logger.info("Showing update view GET ");

		// We find the stock through DAO and load into model
		model.addAttribute("stock", stockDAO.selectById(stockId, Stock.class));

		return "stock/update";
	}

	/**
	 * Handles the POST from the Custom.jsp page to update the Stock.
	 */
	@RequestMapping(value = "/stocks/saveupdate", method = RequestMethod.POST)
	public ModelAndView saveUpdate(Stock stock) {
		logger.info("Save update " + stock.getId());

		stockDAO.update(stock);

		ModelAndView modelAndView = new ModelAndView();

		// We pass the stock received through this object
		modelAndView.addObject("stock", stock);

		// The same as return "stock/saveUpdate"
		modelAndView.setViewName("stock/saveUpdated");
		return modelAndView;
	}
	
	

	/**
	 * Delete the specific stock
	 */
	@RequestMapping(value = "/stocks/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable(value = "id") Integer stockId, Model model) {
		logger.info("Stock detail /delete");
		Stock stock = stockDAO.selectById(stockId, Stock.class);
		stockDAO.delete(stock);
		model.addAttribute("stockId", stockId);

		return "stock/deleted";
	}
	

}
