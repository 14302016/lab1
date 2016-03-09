package lab1;

import java.util.HashMap;

public final class ClassNameContract 
{
	private static ClassNameContract mSingleton = new ClassNameContract();
	
	//<Beverage Name, Class>
	private HashMap<String, Class<? extends Beverage>> mBevClassMap;
	
	//Singleton Design.
	private ClassNameContract()
	{
		mBevClassMap = new HashMap<String, Class<? extends Beverage>>();
		
		//Developers register new beverage classes here.
		//However, this seems a bit ugly. Would it be better if this is stored on a text file?
		//EDIT: Seems like reflection is a bad idea. Changed <Beverage Name, Class Name> to <Beverage, Class>
		//TODO: Add existing class table. First line added as example.
		mBevClassMap.put("espresso", Espresso.class);
	}
	
	public static ClassNameContract getSingleton()
	{
		return mSingleton;
	}
	
	public Beverage getBeverageClass(String name) throws InstantiationException, IllegalAccessException
	{
		Beverage returnVal = null;
		
		String key = name.toLowerCase(); //For case insensitivity
		
		if(mBevClassMap.containsKey(key))
		{
			returnVal = mBevClassMap.get(key).newInstance();
		}
		
		return returnVal;
	}
}
