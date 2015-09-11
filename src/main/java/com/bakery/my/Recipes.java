package com.bakery.my;

import com.bakery.my.xml.Bread;
import com.bakery.my.xml.Cake;
import com.bakery.my.xml.Cookie;
import com.bakery.my.xml.Glaze;
import com.bakery.my.xml.Ingredient;
import com.bakery.my.xml.IngredientList;
import com.bakery.my.xml.Product;
import com.bakery.my.xml.Unit;

/**
 * Contains static functions to create some test data recipes for use with the
 * Bakery demo
 *
 */
public final class Recipes {

	private Recipes() {
	}

	public static Product createChocolateCookie() {
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

		return chocolateCookie;
	}

	public static Product createCinnamonCookie() {
		Cookie cinnamonCookie = new Cookie();
		cinnamonCookie.setName("Cinnamon cookie");
		cinnamonCookie.setCrunchy(true);

		IngredientList ingredientList = new IngredientList();
		cinnamonCookie.setIngredientlist(ingredientList);

		Ingredient flour = new Ingredient();
		flour.setName("flour");
		flour.setUnit(Unit.GRAM);
		flour.setNumber(500);
		ingredientList.getIngredient().add(flour);

		Ingredient cinnamon = new Ingredient();
		cinnamon.setName("cinnamon");
		cinnamon.setUnit(Unit.TEASPOON);
		cinnamon.setNumber(2);
		ingredientList.getIngredient().add(cinnamon);

		Ingredient salt = new Ingredient();
		salt.setName("salt");
		salt.setUnit(Unit.PINCH);
		salt.setNumber(1);
		ingredientList.getIngredient().add(salt);

		Ingredient sugar = new Ingredient();
		sugar.setName("sugar");
		sugar.setUnit(Unit.CUP);
		sugar.setNumber(1);
		ingredientList.getIngredient().add(sugar);

		return cinnamonCookie;
	}

	public static Product createLemonCake() {
		Product lemonCake = new Cake();
		lemonCake.setName("Lemon cake");

		IngredientList ingredientList = new IngredientList();
		lemonCake.setIngredientlist(ingredientList);

		Ingredient flour = new Ingredient();
		flour.setName("flour");
		flour.setUnit(Unit.GRAM);
		flour.setNumber(500);
		ingredientList.getIngredient().add(flour);

		Ingredient milk = new Ingredient();
		milk.setName("skim milk");
		milk.setUnit(Unit.CUP);
		milk.setNumber(0.5);
		ingredientList.getIngredient().add(milk);

		Ingredient lemon = new Ingredient();
		lemon.setName("lemon");
		lemon.setUnit(Unit.NUMBER);
		lemon.setNumber(1);
		ingredientList.getIngredient().add(lemon);

		Ingredient sugar = new Ingredient();
		sugar.setName("sugar");
		sugar.setUnit(Unit.CUP);
		sugar.setNumber(1);
		ingredientList.getIngredient().add(sugar);

		return lemonCake;
	}

	public static Product createStrawberryCake() {
		Cake strawberryCake = new Cake();
		strawberryCake.setName("Strawberry cake");

		IngredientList ingredientList = new IngredientList();
		strawberryCake.setIngredientlist(ingredientList);

		Ingredient flour = new Ingredient();
		flour.setName("flour");
		flour.setUnit(Unit.GRAM);
		flour.setNumber(225);
		ingredientList.getIngredient().add(flour);

		Ingredient butter = new Ingredient();
		butter.setName("butter");
		butter.setUnit(Unit.GRAM);
		butter.setNumber(225);
		ingredientList.getIngredient().add(butter);

		Ingredient eggs = new Ingredient();
		eggs.setName("eggs");
		eggs.setUnit(Unit.NUMBER);
		eggs.setNumber(4);
		ingredientList.getIngredient().add(eggs);

		Ingredient strawberries = new Ingredient();
		strawberries.setName("strawberries");
		strawberries.setUnit(Unit.GRAM);
		strawberries.setNumber(250);
		ingredientList.getIngredient().add(strawberries);

		Glaze glaze = new Glaze();
		glaze.setName("Strawberry glazing");
		IngredientList glazingIngredientList = new IngredientList();
		glaze.setIngredientlist(glazingIngredientList);

		Ingredient glazingSugar = new Ingredient();
		glazingSugar.setName("sugar");
		glazingSugar.setUnit(Unit.CUP);
		glazingSugar.setNumber(0.33);
		glazingIngredientList.getIngredient().add(glazingSugar);

		Ingredient cornstarch = new Ingredient();
		cornstarch.setName("cornstarch");
		cornstarch.setUnit(Unit.TABLESPOON);
		cornstarch.setNumber(1);
		glazingIngredientList.getIngredient().add(cornstarch);

		Ingredient glazingStrawberries = new Ingredient();
		glazingStrawberries.setName("strawberries");
		glazingStrawberries.setUnit(Unit.CUP);
		glazingStrawberries.setNumber(2);
		glazingIngredientList.getIngredient().add(glazingStrawberries);

		strawberryCake.setGlaze(glaze);

		return strawberryCake;
	}

	public static Product createRyeBread() {
		Bread ryeBread = new Bread();
		ryeBread.setName("Rye bread");
		ryeBread.setSlices(30);

		IngredientList ingredientList = new IngredientList();
		ryeBread.setIngredientlist(ingredientList);

		Ingredient flour = new Ingredient();
		flour.setName("rye flour");
		flour.setUnit(Unit.GRAM);
		flour.setNumber(200);
		ingredientList.getIngredient().add(flour);

		Ingredient flour2 = new Ingredient();
		flour2.setName("wholemeal flour");
		flour2.setUnit(Unit.GRAM);
		flour2.setNumber(200);
		ingredientList.getIngredient().add(flour2);

		Ingredient yeast = new Ingredient();
		yeast.setName("yeast");
		yeast.setUnit(Unit.GRAM);
		yeast.setNumber(7);
		ingredientList.getIngredient().add(yeast);

		Ingredient salt = new Ingredient();
		salt.setName("salt");
		salt.setUnit(Unit.TABLESPOON);
		salt.setNumber(0.5);
		ingredientList.getIngredient().add(salt);

		return ryeBread;
	}

}
