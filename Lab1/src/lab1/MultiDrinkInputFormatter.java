package lab1;

import java.util.ArrayList;
import java.util.List;

public class MultiDrinkInputFormatter implements InputFormatter
{
	@Override
	public Beverage[] process(String... args) 
	{
		//Decompose the input into multiple single drink formatted input, then process it through the single drink input format class
		
		SingleDrinkInputFormatter backend = new SingleDrinkInputFormatter();
		List<Beverage> returnVal = new ArrayList<Beverage>();
		
		int inputLen = 0;
		try
		{
			inputLen = Integer.parseInt(args[0]);	
		}
		catch(NumberFormatException ex)
		{
			System.out.println("Illegal input: " + args[0]);
			return null;
		}
		
		
		int argIndex = 1;
		for(int i = 0; i < inputLen; ++i)
		{
			List<String> singleDrinkArgs = new ArrayList<String>();
			while(argIndex < args.length && !args[argIndex].equals(";")) //Get all args until ;
			{
				singleDrinkArgs.add(args[argIndex]);
				++argIndex;
			}
			++argIndex;
			
			//Process the args for a single drink and add it to returnVal
			returnVal.add(backend.process(singleDrinkArgs.toArray(new String[]{}))[0]);
		}
		
		return returnVal.toArray(new Beverage[]{});
	}
}
