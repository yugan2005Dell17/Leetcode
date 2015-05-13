package HeadFirstDesign.java;

import java.util.Observable;
import java.util.Observer;

public class CurrentDisplay implements Observer, Displayer {
	Observable ob;
	private double temp;
	private double humidity;
	private double press;
	
	public CurrentDisplay(WeatherStation ob) {
		this.ob=ob;
		ob.addObserver(this);
	}
	
	public void changeStation(WeatherStation ob){
		this.ob.deleteObserver(this);
		this.ob=ob;
		this.ob.addObserver(this);
		System.out.println("WeatherStation sucessfully changed");
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (this.ob!=o){
			System.out.println("Warning, the notification comes from unknow source!");
			return;
		}
		WeatherStation ws=(WeatherStation) o;
		if (arg==null){
			temp=ws.getTemp();
			humidity=ws.getHumidity();
			press=ws.getPress();
			display();	
		}
		else {
			System.out.println(arg);
		}
		
	}

	@Override
	public void display() {
		System.out.println("The current temperature is: "+ temp);
		System.out.println("The current humidity is: "+ humidity);
		System.out.println("The current pressure is: "+ press);		
	}

}
