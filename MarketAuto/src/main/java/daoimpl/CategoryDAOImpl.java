package daoimpl;

import java.util.ArrayList;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import config.HibernateConfig;
import dao.CategoryDAO;
import dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{
	
	
	Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
	
	@Override
	public List<Category> list() {
		try {
			sessionObj.beginTransaction();
			Query<Category> query = sessionObj.createQuery("from Category where active = ?");
			query.setBoolean(0, true);
			List<Category> result = query.getResultList();
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
	public Category get(int id) {
		return sessionObj.get(Category.class, Integer.valueOf(id));
	}


	public boolean add(Category c) {
		try {
			sessionObj.beginTransaction();
			sessionObj.save(c);
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
	public boolean update(int id, Category category) {
		try {
			sessionObj.beginTransaction();
			Category c = (Category) this.get(id);
			c=category;
			sessionObj.save(c);
			sessionObj.getTransaction().commit();
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} 
		return false;
		}


	@Override
	public boolean delete(int id) {
		try {
			sessionObj.beginTransaction();
			Category c = (Category) this.get(id);
			c.setActive(false);
			sessionObj.save(c);
			sessionObj.getTransaction().commit();
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} 
		return false;
	}

}
