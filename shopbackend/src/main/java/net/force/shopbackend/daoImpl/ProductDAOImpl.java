package net.force.shopbackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.force.shopbackend.dao.ProductDAO;
import net.force.shopbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static List<Product> products = new ArrayList<>();

	@Override
	public List<Product> list() {

		String selectActiveProduct = "FROM Product WHERE active = :active";

		Query query = sessionFactory
						.getCurrentSession()
							.createQuery(selectActiveProduct);

		query.setParameter("active", true);

		return query.getResultList();
	}

	@Override
	public Product get(int id) {
		return sessionFactory
					.getCurrentSession()
						.get(Product.class, Integer.valueOf(id));
	}

	// Method to add product
	@Override
	public boolean add(Product product) {

		try {

			sessionFactory.getCurrentSession().persist(product);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	// Method to update a product
	@Override
	public boolean update(Product product) {

		try {

			sessionFactory
				.getCurrentSession()
					.update(product);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	// Method to delete a product
	@Override
	public boolean delete(Product product) {

		product.setActive(false);
		try {

			sessionFactory
				.getCurrentSession()
					.update(product);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<Product> listActiveProducts() {

		String selectActiveProducts = "FROM Product WHERE active = :active";

		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProducts, Product.class)
						.setParameter("active", true)
							.getResultList();
	}

}
