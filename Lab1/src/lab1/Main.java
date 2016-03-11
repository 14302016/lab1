package lab1;

import java.text.DecimalFormat;

public class Main 
{
	public static void main(String[] args) 
	{
		String[] disArr = new String[args.length];
		for (int j = 0; j < args.length; j++) 
		{
			disArr[j] = args[j].toLowerCase();
		}

		int i;
		StringBuilder bevStrBuilder = new StringBuilder();
		for (i = 0; i < disArr.length; i++)
		{
			if (disArr[i].equals("small") || disArr[i].equals("medium")
					|| disArr[i].equals("large"))
			{
				break;
			}
			else
			{
				bevStrBuilder.append(disArr[i]);
			}
		}

		if (i >= disArr.length) {
			System.out.println("Must set a size!");
			return;
		}

		String beveStr = bevStrBuilder.toString();

		Beverage order = null;
		try
		{
			order = InputHandler.getSingleton().getBeverageInstance(beveStr);
		}
		catch (InstantiationException | IllegalAccessException e) 
		{
			System.out.println("Error instantiating selected beverage class.");
			e.printStackTrace();
			return;
		}
		
		//Check if drink with input name exists
		if(order == null)
		{
			System.out.println("Illegal input: " + beveStr);
			return;
		}

		order.setSize(disArr[i]);
		
		//Add ingredients
		for (i++; i < disArr.length; i++) 
		{
			order = InputHandler.getSingleton().getIngredientInstance(disArr[i], order);
			
			//Check if the input ingredient exists
			if(order == null)
			{
				System.out.println("Illegal input: " + disArr[i]);
			}
		}

		/**
		 * How do I get the description of each order instead of doing this
		 * stupid thing forever (except for printing the args)?
		 */
		
		if (order instanceof BeverageWithIngredient) {
			((BeverageWithIngredient) order).getDescription();
		} else if (order instanceof Espresso) {
			((Espresso) order).getDescription();
		}
		// and so on...
		
		order.getDescription(); //Does this solve the problem?

		DecimalFormat df = new DecimalFormat(".0");
		System.out.println("The total cost of your order is: "
				+ df.format(order.cost()));
	}
}