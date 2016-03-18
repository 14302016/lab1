package lab1;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultiDrinkInputFormatterTest 
{
	MultiDrinkInputFormatter baseClass;
	SingleDrinkInputFormatter reference;
	
	public MultiDrinkInputFormatterTest() 
	{
		baseClass = new MultiDrinkInputFormatter();
		reference = new SingleDrinkInputFormatter();
	}
	
	@Test
	public void testProcess() 
	{
		double expected = reference.process("espresso", "large")[0].cost() + reference.process("cappuccino", "medium")[0].cost();
		Beverage results[] = baseClass.process("2", "espresso", "large", ";", "cappuccino", "medium");
		double actual = results[0].cost() + results[1].cost();
		assertEquals(expected, actual, 0.01);
	}

}
