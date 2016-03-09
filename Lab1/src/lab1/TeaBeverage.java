package lab1;

public abstract class TeaBeverage extends Beverage {
	private String size;

	public TeaBeverage() {
		super.sizeFactor = new TeaBased();
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double cost() {
		return super.cost() + super.sizeFactor.sizeCost(size);
	}
}
