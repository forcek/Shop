package net.force.shopbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.force.shopbackend.dao.ProductDAO;
import net.force.shopbackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;

	private static ProductDAO productDAO;

	private static Product product;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("net.force.shopbackend");
		context.refresh();

		productDAO = (ProductDAO) context.getBean("productDAO");

	}

	// @Test
	// public void testAddProduct(){
	//
	// product= new Product();
	//
	// product.setName("Single Bed");
	// product.setDescription("Single Bed of size 6x2 in good condition.");
	// product.setImageURL("bed.png");
	// product.setPrice(4000);

	// assertEquals("Successfully added a product inside the table", true,
	// productDAO.add(product));
	//
	// }

	// @Test
	// public void testGetProduct(){
	//
	// product = productDAO.get(2);
	//
	// assertEquals("Successfully fetched a product from the table ","Single
	// Bed", product.getName());
	//
	// }

	// @Test
	// public void testUpdateProduct(){
	//
	// product = productDAO.get(2);
	//
	// product.setName("SINGLEBED");
	//
	// assertEquals("Successfully updated a product in the table ",true,
	// productDAO.update(product));
	//
	// }

	// @Test
	// public void testDeleteProduct(){
	//
	// product = productDAO.get(2);
	//
	// assertEquals("Successfully deleted a product from the table ",true,
	// productDAO.delete(product));
	//
	// }

	/*
	 * @Test public void testListProduct(){
	 * 
	 * product = productDAO.get(2);
	 * 
	 * assertEquals("Successfully feteched list of products from the table ",1,
	 * productDAO.list().size());
	 * 
	 * }
	 * 
	 */

	/*
	 * @Test public void testCRUDProduct(){
	 * 
	 * 
	 * //add operation product= new Product();
	 * 
	 * product.setName("Single Bed");
	 * product.setDescription("Single Bed of size 6x2 in good condition.");
	 * product.setImageURL("bed.png"); product.setPrice(4000);
	 * product.setQuantity(1);
	 * 
	 * 
	 * assertEquals("Successfully added a product inside the table", true,
	 * productDAO.add(product));
	 * 
	 * 
	 * product= new Product();
	 * 
	 * product.setName("Cooler");
	 * product.setDescription("Second hand cooler of hitachi in good condition."
	 * ); product.setImageURL("cooler.png"); product.setPrice(2000);
	 * product.setQuantity(1);
	 * 
	 * 
	 * assertEquals("Successfully added a product inside the table", true,
	 * productDAO.add(product));
	 * 
	 * 
	 * product= new Product();
	 * 
	 * product.setName("TV"); product.
	 * setDescription("Second hand LG telivision of size 32'inches in good condition."
	 * ); product.setImageURL("TV.png"); product.setPrice(2500);
	 * product.setQuantity(1);
	 * 
	 * 
	 * assertEquals("Successfully added a product inside the table", true,
	 * productDAO.add(product));
	 * 
	 * 
	 * //updating 
	 * product = productDAO.get(3);
	 * 
	 * product.setName("Telivision");
	 * 
	 * assertEquals("Successfully updated a product in the table",true,
	 * productDAO.update(product));
	 * 
	 * 
	 * //Delete
	 * assertEquals("Successfully deleted a product from the table",true,
	 * productDAO.delete(product));
	 * 
	 * //Fetching the list
	 * assertEquals("Successfully fetched the list of the products from the table"
	 * ,2,productDAO.list().size());
	 * 
	 * 
	 * }
	 * 
	 */

	@Test
	public void testListActiveProducts() {

	/*	assertEquals("Successfully fetched list of active products from the table.", 2,
				productDAO.listActiveProducts().size());*/
		
		product = productDAO.get(11);
		assertEquals("Successfully deleted a product from the table",true,productDAO.delete(product));
	}

}
