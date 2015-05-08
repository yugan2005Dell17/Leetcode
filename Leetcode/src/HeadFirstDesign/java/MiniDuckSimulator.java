package HeadFirstDesign.java;

public class MiniDuckSimulator {

	public static void main(String[] args) {
		MallarDuck myMallarDuck = new MallarDuck();
		
		myMallarDuck.fly();
		myMallarDuck.quake();
		
		ModelDuck myModelDuck = new ModelDuck();
		myModelDuck.fly();
		myModelDuck.quake();
		myModelDuck.setFlyBehavior(new FlyRocketPowered());
		myModelDuck.fly();

	}

}
