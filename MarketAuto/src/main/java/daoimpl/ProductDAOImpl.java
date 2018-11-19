package daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import config.HibernateConfig;
import dao.ProductDAO;
import dto.Category;
import dto.Product;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO{

	Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
	
	@Override
	public Product get(int id) {
		return sessionObj.get(Product.class, Integer.valueOf(id));
	}

	@Override
	public List<Product> list() {
		try {
			sessionObj.beginTransaction();
			Query<Product> query = sessionObj.createQuery("from Product");
			List<Product> result = query.getResultList();
			sessionObj.getTransaction().commit();
			return result;
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean add(Product p) {
		try {
			sessionObj.beginTransaction();
			sessionObj.save(p);
			sessionObj.getTransaction().commit();
			return true;
		}catch(HibernateException exception){
		     System.out.println("Problem creating session factory");
		     exception.printStackTrace();
		     return false;
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
			return false;
		} 
	}

	@Override
	public List<Product> listActiveProducts() {
		try {
			sessionObj.beginTransaction();
			Query<Product> query = sessionObj.createQuery("from Product where is_active = ?");
			query.setBoolean(0, true);
			List<Product> result = query.getResultList();
			sessionObj.getTransaction().commit();
			return result;
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> listActiveProductsByCategory(int catId) {
		try {
			sessionObj.beginTransaction();
			Query<Product> query = sessionObj.createQuery("from Product where is_active = ? and category_id = ?");
			query.setBoolean(0, true);
			query.setInteger(1, catId);
			List<Product> result = query.getResultList();
			sessionObj.getTransaction().commit();
			return result;
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(int id, Product p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
}
