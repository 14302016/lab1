package lab1;

public class SingleDrinkInputFormatter implements InputFormatter 
{
	@Override
	public Beverage[] process(String... args) 
	{
		String[] disArr = new String[args.length];
		for (int j = 0; j < args.length; j++) 
		{
			disArr[j] = args[j].toLowerCase();
		}

		int i;
		StringBuilder bevStrBuilder = new StringBuilder();
		bevStrBuilder.append(disArr[0]);
		for (i = 1; i < disArr.length - 1; i++) //Add any intermediate arguments between first word and size
		{
			bevStrBuilder.append(" " + disArr[i]);
		}

		if (i >= disArr.length) {
			System.out.println("Must set a size!");
			return null;
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
			return null;
		}
		
		//Check if drink with input name exists
		if(order == null)
		{
			System.out.println("Illegal input: " + beveStr);
			return null;
		}

		order.setSize(disArr[disArr.length - 1]);
		
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
		
		return new Beverage[]{order};
	}
}
