package HeadFirstDesign.java;

public class SimpleController {
	private Command slot;
	
	public void setCommand(Command cmd){
		slot=cmd;
	}
	
	public void pressButton(){
		slot.execute();
	}

}
