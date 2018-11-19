package marketAuto.controller;

import daoimpl.CategoryDAOImpl;
import daoimpl.ProductDAOImpl;
//import daoimpl.ProductDAOImpl;
import dto.Category;
import javassist.bytecode.Descriptor.Iterator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CategoryDAOImpl a = new CategoryDAOImpl();
    	Category c = new Category();//(0, "name", "description", "imageURL", true);
    	c.setActive(true);
    	c.setName("name2");
    	c.setDescription("desc");
    	c.setImageURL("urlsimage");
        //a.add(c);
//        c = a.get(0);
//        System.out.println(c.getName());
//        c.setName("newCategName");
       //a.delete(0);
    	System.out.println(a.list());
    	ProductDAOImpl pp = new ProductDAOImpl();
    	System.out.println(pp.listActiveProducts());
	}

}