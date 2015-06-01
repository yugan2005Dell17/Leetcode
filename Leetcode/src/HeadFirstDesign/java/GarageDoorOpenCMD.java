package HeadFirstDesign.java;

public class GarageDoorOpenCMD implements Command {
	private GarageDoor gd;
	
	public GarageDoorOpenCMD(GarageDoor gd){
		this.gd=gd;
	}

	@Override
	public void execute() {
		gd.up();

	}

}
