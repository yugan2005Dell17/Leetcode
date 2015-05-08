package HeadFirstDesign.java;

public class ModelDuck extends Duck {
	
	public ModelDuck(){
		flyBehavior = new FlyNoWay();
		quakeBehavior = new Quake();
	}

	@Override
	public void display() {
		System.out
				.println("I am a model duck, I cannot fly but I can quake");
		
	}

}
