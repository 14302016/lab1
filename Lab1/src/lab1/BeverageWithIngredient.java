package lab1;

public class BeverageWithIngredient extends Beverage {
	private Beverage drink;
	protected String description;

	public BeverageWithIngredient(Beverage drink) {
		this.drink = drink;
		this.description = drink.getDescription();
	}
	
	public String getDescription(){
		return description;
	}
	
	public double cost() {
		return drink.cost();
	}
	
	public void setSize(String size)
	{
		drink.setSize(size);
	}
}
