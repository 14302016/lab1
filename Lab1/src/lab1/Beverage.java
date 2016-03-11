package lab1;

public abstract class Beverage {
	protected SizeFactor sizeFactor;

	public double cost() {
		return 0;
	}
	
	public abstract String getDescription();
	public abstract void setSize(String size);
}
