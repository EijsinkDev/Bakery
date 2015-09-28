package com.bakery.my;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import com.bakery.my.xml.Product;
import com.bakery.my.xml.ProductList;

/**
 * JAXB Example class
 * 
 * @author Berry Klomp
 */
public final class Bakery {

	/**
	 * Name of our temp XML file
	 */
	private static final String tempName = "jaxbExample";
 
	/**
	 * XML Extension
	 */
	private static final String tempExtension = ".xml";

	/**
	 * Constructor
	 */
	private Bakery() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = null;
		try {
			file = File.createTempFile(tempName, tempExtension);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		try{		
			writeXml(createProductList(), file);
			ProductList readList = (ProductList) readXml(file);
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
	 * @param file
	 *        file from which XML will be read
	 * @return an {@link Object} which should be of the {@link ProductList}
	 *         class
	 * @throws JAXBException
	 */
	public static Object readXml(File file) throws JAXBException {
		System.out.println("Reading XML from " + file.getPath());
		

		JAXBContext jc = JAXBContext.newInstance(ProductList.class);
		Unmarshaller u = jc.createUnmarshaller();
		Object o = u.unmarshal(new StreamSource(file));

		return o;
	}

	/**
	 * Marshalls XML {@link ProductList} which is written to a file
	 * 
	 * @param productList
	 *          a {@link ProductList} Java class possibly containing multiple
	 *            {@link Product}s
	 * @param file
	 *          file in which the XML will be written
	 * @throws JAXBException
	 * 				
	 */
	public static void writeXml(ProductList productList, File file) throws JAXBException{
		System.out.println("Writing XML to " + file.getPath());

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
