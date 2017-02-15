/**
 * 
 */
package org.sistema.springmvc.forms.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.sistema.springmvc.forms.models.Producto;
import org.sistema.springmvc.forms.models.Stock;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * implementation of ProductDAO
 * 
 * @author Eugenia Pérez Martínez
 * @email eugenia_perez@cuatrovientos.org
 *
 */

public class ProductoDAO extends GenericDAO<Producto> {


		/**
	 * Selects all product types by name
	 * 
	 * @return List of products
	 */
	@Transactional(readOnly = true)
	public List<Producto> selectByName(String name) {

		List<Producto> products = null;

			Query query = getSession()
							.createQuery("from Producto u where u.login LIKE :login");
		    query.setParameter("login", "%"+name+"%");
		    
			// We get a generic object list
			products = query.list();

		return products;
	}

}
