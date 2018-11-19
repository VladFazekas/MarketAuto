package marketAuto.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.CategoryDAO;
import dao.ProductDAO;
import dto.Product;

@Controller
@RequestMapping("/json-data")
public class JsonDataController {

	@Autowired
	private ProductDAO productDAO;

	@RequestMapping("/all-products")
	@ResponseBody
	public List<Product> getAllProducts() {
		Iterator<Product> it;
		it = productDAO.listActiveProducts().iterator();
		String s = "[ \n";
		while (it.hasNext()) {
			s += it.next().toString() + ",\n";
		}
		s = s.substring(0, s.length() - 2);
		s += "]";
		return productDAO.listActiveProducts();
	}

	@RequestMapping("/category-{id}-all-products")
	@ResponseBody
	public String getAllProductsByCategory(@PathVariable int id) {
		Iterator<Product> it;
		it = productDAO.listActiveProductsByCategory(id).iterator();
		String s = "[ \n";
		while (it.hasNext()) {
			s += it.next().toString() + ",\n";
		}
		s = s.substring(0, s.length() - 2);
		s += "]";
		return s;
	}

}
