package lab1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

public class InputHandlerTest {

	InputHandler mBase = InputHandler.getSingleton();
	
	@Parameters
	public static Collection cases()
	{	
		return Arrays.asList(new Object[][]
				{
					{"espresso"}
				});
	}
	
	@Test
	public void testGetBeverageInstance() throws InstantiationException, IllegalAccessException 
	{
		assertTrue(mBase.getBeverageInstance("espresso").getClass().getName().equals(Espresso.class.getName()));
		assertTrue(mBase.getBeverageInstance("tea latte").getClass().getName().equals(Milk.class.getName()) &&
				mBase.getBeverageInstance("tea latte").getDescription().equals("Red Tea milk"));
	}

}
