package lab1;

public class GreenTea extends TeaBeverage {
	private String description;
	
	public GreenTea() {
		description = "Green Tea";
	}

	@Override
	public String getDescription() {
		return description;
	}
}
