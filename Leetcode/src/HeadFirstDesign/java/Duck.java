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

	public void setFlyBehavior(Flyable flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuakeBehavior(Quakeable quakeBehavior) {
		this.quakeBehavior = quakeBehavior;
	}

}
