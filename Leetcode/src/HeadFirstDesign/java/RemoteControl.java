package HeadFirstDesign.java;

public class RemoteControl {
	private Command[] onCommand;
	private Command[] offCommand;
	int slotNum;
	
	public RemoteControl(int slotNum){
		this.slotNum=slotNum;
		onCommand = new Command[slotNum];
		offCommand = new Command[slotNum];
		
		for (int i=0; i<slotNum; i++){
			onCommand[i]=new NoCommand();
			offCommand[i]= new NoCommand();
		}
	}
	
	public void setCommand(int slot, Command slotOnCommand, Command slotOffCommand){
		onCommand[slot]=slotOnCommand;
		offCommand[slot]=slotOffCommand;
	}
	
	public void pressOnButton(int slot){
		onCommand[slot].execute();
	}
	
	public void pressOffButton(int slot){
		offCommand[slot].execute();
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("---------Remote Controller---------");
		sb.append(System.lineSeparator());
		for (int i=0; i<slotNum; i++){
			sb.append("[Slot "+i+"]: "+onCommand[i].getClass().getName()+"\t"+offCommand[i].getClass().getName());
			sb.append(System.lineSeparator());
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
