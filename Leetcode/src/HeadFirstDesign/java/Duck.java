package HeadFirstDesign.java;

public abstract class Duck {
	Flyable flyBehavior;
	Quakeable quakeBehavior;
	
	public void swim(){
		System.out.println("I of course can swim. I am a duck!");
	}
	
	public abstract void display();
	
	public void fly(){
		flyBehavior.fly();
	}
	
	public void quake() {
		quakeBehavior.quak();
	}

}
