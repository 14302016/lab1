package lab1;

import java.util.HashMap;

public class CoffeeBased implements SizeFactor 
{
	private HashMap<String, Double> mSizeCost;
	
	public CoffeeBased()
	{
		mSizeCost = new HashMap<String, Double>();
		
		mSizeCost.put("small", 0.4);
		mSizeCost.put("medium", 0.7);
		mSizeCost.put("large", 1.0);
	}
	
	@Override
	public double sizeCost(String size) 
	{
		return mSizeCost.get(size);
	}

}
