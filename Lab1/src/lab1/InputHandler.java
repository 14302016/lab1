package lab1;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public final class InputHandler 
{
	private static InputHandler mSingleton = new InputHandler();
	
	//<Beverage_Name, {Base_Drink_Class, Ingredients...}>
	private HashMap<String, Class<? extends Beverage>[]> mBevClassMap;
	
	//<Ingredient_Name, Ingredient_Class>
	private HashMap<String, Class<? extends BeverageWithIngredient>> mIngredientMap;
	
	//Singleton Design.
	@SuppressWarnings("unchecked")
	private InputHandler()
	{
		mBevClassMap = new HashMap<String, Class<? extends Beverage>[]>();
		mIngredientMap = new HashMap<String, Class<? extends BeverageWithIngredient>>();
		
		//Developers register new beverage classes here.
		//First class have to be the base drink.
		addBevClass("espresso", Espresso.class);
		addBevClass("houseblend", HouseBlend.class);
		addBevClass("mocha", Espresso.class, Chocolate.class);
		addBevClass("latte", Espresso.class, Milk.class);
		addBevClass("cappuccino", Espresso.class, WhipCream.class);
		addBevClass("green tea", GreenTea.class);
		addBevClass("red tea", RedTea.class);
		addBevClass("white tea", WhiteTea.class);
		addBevClass("flower tea", GreenTea.class, Jasmine.class);
		addBevClass("ginger tea", GreenTea.class, Ginger.class);
		addBevClass("tea latte", RedTea.class, Milk.class);
	
		//Ingredients are registered here.
		addIngClass("chocolate", Chocolate.class);
		addIngClass("ginger", Ginger.class);
		addIngClass("milk", Milk.class);
		addIngClass("jasmine", Jasmine.class);
		addIngClass("whip", WhipCream.class);
	}
	
	private void addBevClass(String name, Class<? extends Beverage>... classes)
	{
		mBevClassMap.put(name, classes);
	}
	
	private void addIngClass(String name, Class<? extends BeverageWithIngredient> ingClass)
	{
		mIngredientMap.put(name, ingClass);
	}
	
	public static InputHandler getSingleton()
	{
		return mSingleton;
	}
	
	public Beverage getBeverageInstance(String name) throws InstantiationException, IllegalAccessException
	{
		Beverage returnVal = null;
		
		Class<? extends Beverage>[] recipe;
		recipe = mBevClassMap.get(name);
		
		if(recipe == null) return null; //Return null if name not found in map
		
		returnVal = recipe[0].newInstance();
		
		//For each ingredient, create an BeverageWithIngredient with previous (mixed) drink as base drink
		for(int i = 1; i < recipe.length; ++i)
		{
			try 
			{
				returnVal = recipe[i].getDeclaredConstructor(Beverage.class).newInstance(returnVal);
			}
			catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException
					| SecurityException e) {
				System.out.println("Unable to construct BeverageWithIngredient class. (Unable to add ingredient" + recipe[i].getName() + ")");
				e.printStackTrace();
				return null;
			}
		}
		
		return returnVal;
	}
	
	public BeverageWithIngredient getIngredientInstance(String name, Beverage base)
	{
		try 
		{
			return mIngredientMap.get(name).getDeclaredConstructor(Beverage.class).newInstance(base);
		}
		catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) 
		{
			System.out.println("Ingredient instantiation failed.");
			e.printStackTrace();
			return null;
		}
	}
}
