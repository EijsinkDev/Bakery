package com.bakery.my;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import com.bakery.my.xml.Product;
import com.bakery.my.xml.ProductList;

/**
 * JAXB Example class
 */
public final class Bakery {

	/**
	 * Storage location of our XML file
	 */
	public static final String FILEPATH = System.getProperty("java.io.tmpdir") + "jaxbExample.xml";

	/**
	 * Constructor
	 */
	private Bakery() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			writeXml(createProductList(), FILEPATH);
			ProductList readList = (ProductList) readXml(FILEPATH);
			printList(readList);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates a {@link ProductList} containing test data
	 * 
	 * @return test data
	 */
	public static ProductList createProductList() {
		ProductList list = new ProductList();
		list.getProduct().add(Recipes.createChocolateCookie());
		list.getProduct().add(Recipes.createCinnamonCookie());
		list.getProduct().add(Recipes.createLemonCake());
		list.getProduct().add(Recipes.createStrawberryCake());
		list.getProduct().add(Recipes.createRyeBread());
		return list;
	}

	/**
	 * Unmarshalls ProductList XML data read from a file
	 * 
	 * @param filePath
	 *            complete path to a file, should have read permission
	 * @return an {@link Object} which should be of the {@link ProductList}
	 *         class
	 */
	public static Object readXml(String filePath) throws JAXBException {
		System.out.println("Reading XML from " + filePath);
		
		JAXBContext jc = JAXBContext.newInstance(ProductList.class);
		Unmarshaller u;
		u = jc.createUnmarshaller();
		Object o = u.unmarshal(new StreamSource(new File(filePath)));

		return o;
	}

	/**
	 * Marshalls XML {@link ProductList} which is written to a file
	 * 
	 * @param productList
	 *            a {@link ProductList} Java class possibly containing multiple
	 *            {@link Product}s
	 * @param filePath
	 *            complete path to a file, should have write permission
	 * 
	 */
	public static void writeXml(ProductList productList, String filePath) throws JAXBException{
		System.out.println("Writing XML to " + filePath);
		
		File file = new File(filePath);
		JAXBContext jaxbContext = JAXBContext.newInstance(ProductList.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(productList, file);
	}

	/**
	 * Print products and ingredients in a human-readable way to the standard
	 * output
	 * 
	 * @param list
	 *            a list of {@link Product}s to be printed
	 */
	public static void printList(ProductList list) {
		System.out.println("Printing products read from XML:");
		for (Product product : list.getProduct()) {
			System.out.println(product);
		}
	}
}
