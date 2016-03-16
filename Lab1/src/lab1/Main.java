package lab1;

import java.text.DecimalFormat;

public class Main 
{
	public static void main(String[] args) 
	{
		InputFormatter inputFormatter = null;
		
		if(args[0].matches("^[1-9]\\d*$"))
		{
			//TODO: Initialize class after implementation
			System.out.println("This input format is not supported yet.");
			return;
		}
		else
		{
			inputFormatter = new SingleDrinkInputFormatter();
		}
		
		Beverage bevs[] = inputFormatter.process(args);
		double cost = 0.0d;
		
		//Sum all the costs
		for (Beverage bev : bevs) 
		{
			cost += bev.cost();
		}
		
		DecimalFormat df = new DecimalFormat(".0");
		System.out.println("The total cost of your order is: "
				+ df.format(cost));
	}
}