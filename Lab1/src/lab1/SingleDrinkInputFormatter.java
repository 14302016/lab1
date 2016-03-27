package lab1;

public class SingleDrinkInputFormatter implements InputFormatter 
{
	@Override
	public Beverage[] process(String... args) 
	{	
		int i = 0;
		
		Beverage order = null;
		
		try
		{
			order = InputHandler.getSingleton().getBeverageInstance(args[0]);
			i = 1;
			if(order == null)
			{
				order = InputHandler.getSingleton().getBeverageInstance(args[0] + " " + args[1]);
				i = 2;
			}
		}
		catch (InstantiationException | IllegalAccessException e) 
		{
			System.out.println("Error instantiating selected beverage class.");
			e.printStackTrace();
			return null;
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Not enough input arguments");
			return null;
		}
		
		String[] disArr = new String[args.length];
		for (int j = 0; j < args.length; j++) 
		{
			disArr[j] = args[j].toLowerCase();
		}

		//Check if drink with input name exists
		if(order == null)
		{
			System.out.println("The specified base drink is not found");
			return null;
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
		
		return new Beverage[]{order};
	}
}
