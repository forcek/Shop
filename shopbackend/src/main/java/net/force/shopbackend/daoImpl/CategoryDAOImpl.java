package net.force.shopbackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.force.shopbackend.dao.CategoryDAO;
import net.force.shopbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();
	
	static {
		Category category = new Category();
		
		category.setId(1);
		category.setName("Second Hand Items");
		category.setDescription("Second hand item for low prices");
		category.setImageURL("aag.png");
		
		categories.add(category);
		
	}
	
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		
		return categories;
	}

}
