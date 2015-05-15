package HeadFirstDesign.java;

public class Espresso implements Beverage {

	@Override
	public String getDescription() {
		return "Espresso";
	}

	@Override
	public float cost() {
		return 1.99f;
	}
	

}
