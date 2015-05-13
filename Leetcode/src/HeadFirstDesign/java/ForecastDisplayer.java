package HeadFirstDesign.java;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplayer implements Displayer, Observer {
	private double temp;
	private double humidity;
	private double press;
	private double preTemp;
	private double preHumidity;
	private double prePress;
	private Observable ob;
	
	public ForecastDisplayer(WeatherStation ws){
		this.ob=ws;
		ws.addObserver(this);
		temp=-1;
		humidity=-1;
		press=-1;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o!=ob){
			System.out.println("Wrong station!");
			return;
		}
		
		WeatherStation ws = (WeatherStation) ob;
		preTemp = temp;
		preHumidity = humidity;
		prePress = press;
		
		temp = ws.getTemp();
		humidity = ws.getHumidity();
		press = ws.getPress();
		
		display();

	}

	@Override
	public void display() {
		System.out.print("Forecast: ");
		if (press > prePress) {
			System.out.println("Improving weather on the way!");
		} else if (press == prePress) {
			System.out.println("More of the same");
		} else if (press < prePress) {
			System.out.println("Watch out for cooler, rainy weather");
		}
	}

}
