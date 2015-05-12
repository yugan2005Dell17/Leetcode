package HeadFirstDesign.java;

import java.util.Observable;

public class WeatherStation extends Observable {
	private double temp;
	private double humidity;
	private double press;
	
	public void setWeather(double temp, double humidity, double press){
		this.temp=temp;
		this.humidity=humidity;
		this.press=press;
		stateChanged();
	}
	
	private void stateChanged(){
		setChanged();
		if (temp<30) {
			notifyObservers();
		}
		else {
			notifyObservers("Alert!, temp is killing people at "+temp);
		}
	}

	public double getTemp() {
		return temp;
	}

	public double getHumidity() {
		return humidity;
	}

	public double getPress() {
		return press;
	}	

}
