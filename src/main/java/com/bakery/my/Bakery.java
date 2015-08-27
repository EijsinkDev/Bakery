package com.bakery.my;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import com.bakery.my.xml.Cookie;
import com.bakery.my.xml.Ingredient;
import com.bakery.my.xml.IngredientList;
import com.bakery.my.xml.Product;
import com.bakery.my.xml.ProductList;
import com.bakery.my.xml.Unit;

public class Bakery {

	public static String FILENAME = "Z:\\file.xml";

	ProductList productList;

	public Bakery() {

	}

	public static void main(String[] args) {

		writeXml(createProductList());
		ProductList readList = (ProductList) readXml(FILENAME);

		printList(readList);
	}

	public static ProductList createProductList() {
		ProductList list = new ProductList();

		Product chocolateCookie = new Cookie();
		chocolateCookie.setName("Chocolate cookie");

		IngredientList ingredientList = new IngredientList();
		chocolateCookie.setIngredientlist(ingredientList);

		Ingredient flower = new Ingredient();
		flower.setName("flower");
		flower.setUnit(Unit.GRAM);
		flower.setNumber(500);
		ingredientList.getIngredient().add(flower);

		Ingredient salt = new Ingredient();
		salt.setName("salt");
		salt.setUnit(Unit.PINCH);
		salt.setNumber(1);
		ingredientList.getIngredient().add(salt);

		Ingredient eggs = new Ingredient();
		eggs.setName("eggs");
		eggs.setUnit(Unit.NUMBER);
		eggs.setNumber(3);
		ingredientList.getIngredient().add(eggs);

		Ingredient chocolate = new Ingredient();
		chocolate.setName("chocolate");
		chocolate.setUnit(Unit.GRAM);
		chocolate.setNumber(100);
		ingredientList.getIngredient().add(chocolate);

		list.getProduct().add(chocolateCookie);

		return list;
	}

	public static Object readXml(String filePath) {
		Object o = null;

		try {
			JAXBContext jc = JAXBContext.newInstance(ProductList.class);
			Unmarshaller u;
			u = jc.createUnmarshaller();
			o = u.unmarshal(new StreamSource(new File(filePath)));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return o;
	}

	public static void writeXml(ProductList productList) {
		try {

			File file = new File(FILENAME);
			JAXBContext jaxbContext = JAXBContext.newInstance(ProductList.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(productList, file);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static void printList(ProductList list) {
		System.out.println("Products:");
		for (Product product : list.getProduct()) {
			System.out.println(product);
		}
	}
}
