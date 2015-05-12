package HeadFirstDesign.java;

import java.util.Observable;
import java.util.Observer;

public class CurrentDisplay implements Observer, Displayer {
	WeatherStation ws;
	private double temp;
	private double humidity;
	private double press;
	
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof WeatherStation){
			ws = (WeatherStation) o;

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
		
	}

	@Override
	public void display() {
		System.out.println("The current temperature is: "+ temp);
		System.out.println("The current humidity is: "+ humidity);
		System.out.println("The current pressure is: "+ press);		
	}

}
