package HeadFirstDesign.java;

public class WeatherTester {
	public static void main(String[] args){
		WeatherStation tester = new WeatherStation();
		CurrentDisplay testPlayer = new CurrentDisplay();
		tester.addObserver(testPlayer);
		tester.setWeather(23, 0.97, 10000);
		tester.setWeather(86, 0.93, 5000);
	}

}
