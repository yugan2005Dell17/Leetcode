package HeadFirstDesign.java;

public class StarbuzzCoffee {
	
	public static void main(String[] args){
		Beverage bev1= new Espresso();
		bev1=new Mocha(bev1);
		bev1=new Whip(bev1);
		
		System.out.println(bev1.getDescription());
		System.out.println(bev1.cost());
		
	}

}
