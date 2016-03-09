package lab1;

public abstract class CoffeeBeverage extends Beverage {
	private String size;

	public CoffeeBeverage() {
		super.sizeFactor = new CoffeeBased();
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double cost() {
		return super.cost() + super.sizeFactor.sizeCost(size);
	}
}
