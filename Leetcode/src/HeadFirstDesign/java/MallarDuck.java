package HeadFirstDesign.java;

public class MallarDuck extends Duck{
	
	public MallarDuck() {
		quakeBehavior = new Quake();
		flyBehavior = new FlyWithWings();
	}

	@Override
	public void display() {
		System.out.println("I am a real Duck - MallarDuck");
		
	}

}
