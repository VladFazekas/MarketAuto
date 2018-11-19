package dao;

import java.util.List;

import dto.Product;

public interface ProductDAO {

	Product get(int id);
	List<Product> list();
	boolean add(Product p);
	boolean update(int id, Product p);
	boolean delete(int id);
	
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int catId);
}
