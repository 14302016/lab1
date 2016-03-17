package lab1;

import java.util.HashMap;

public class TeaBased implements SizeFactor 
{
	private HashMap<String, Double> mSizeCost;
	
	public TeaBased()
	{
		mSizeCost = new HashMap<String, Double>();
		mSizeCost.put("small", 0.2);
		mSizeCost.put("medium", 0.5);
		mSizeCost.put("large", 0.7);
		mSizeCost.put("grand", 0.9);
		
	}
	
	@Override
	public double sizeCost(String size) 
	{
		return mSizeCost.get(size);
	}

}
