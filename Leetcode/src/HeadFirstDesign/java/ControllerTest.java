package HeadFirstDesign.java;

public class ControllerTest {

	public static void main(String[] args) {
		RemoteControl rc= new RemoteControl(7);
		rc.setCommand(0, new LightOnCommand(new Light("Living Room")), new LightOffCommand(new Light("Living Room")));
		rc.pressOnButton(0);
		rc.pressOffButton(0);
		System.out.println(rc);

	}

}
