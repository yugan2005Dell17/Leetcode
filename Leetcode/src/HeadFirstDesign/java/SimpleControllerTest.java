package HeadFirstDesign.java;

public class SimpleControllerTest {
	
	public static void main(String[] args){
		SimpleController myController = new SimpleController();
		Light livingRoomLight = new Light("Livingroom");
		
		Command slot = new LightOnCommand(livingRoomLight);
		myController.setCommand(slot);
		
		myController.pressButton();
		
		GarageDoor gd = new GarageDoor();
		slot = new GarageDoorOpenCMD(gd);
		
		myController.setCommand(slot);
		myController.pressButton();
	}

}
