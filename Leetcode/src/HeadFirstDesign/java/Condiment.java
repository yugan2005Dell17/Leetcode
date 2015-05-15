package HeadFirstDesign.java;

public abstract class Condiment implements Beverage {
	private Beverage beverage;
	private String condimentDes;
	private float price;
	
	public Condiment(Beverage bev, String des, float price){
		this.beverage = bev;
		this.condimentDes = des;
		this.price=price;
	}
	
	public String getDescription(){
		return beverage.getDescription()+", "+this.condimentDes;
	}
	
	public float cost(){
		return beverage.cost()+this.price;
	}

}
