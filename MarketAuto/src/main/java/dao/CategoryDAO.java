package dao;

import java.util.List;

import dto.Category;

public interface CategoryDAO {

	List<Category> list();
	Category get(int id);
	boolean add(Category category);
	boolean update(int id, Category category);
	boolean delete(int id);
}
