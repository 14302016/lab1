package lab1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

public class ClassNameContractTest {

	ClassNameContract mBase = ClassNameContract.getSingleton();
	
	@Parameters
	public static Collection cases()
	{	
		return Arrays.asList(new Object[][]
				{
					{"espresso"}
				});
	}
	
	@Test
	public void testGetBeverageClass() throws InstantiationException, IllegalAccessException 
	{
		assertTrue(mBase.getBeverageClass("espresso").getClass().getName().equals(Espresso.class.getName()));
	}

}
