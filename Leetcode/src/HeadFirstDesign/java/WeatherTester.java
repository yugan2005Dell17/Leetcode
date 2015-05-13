package HeadFirstDesign.java;

public class WeatherTester {
	public static void main(String[] args){
		WeatherStation tester = new WeatherStation();
		CurrentDisplay testPlayer = new CurrentDisplay(tester);
		ForecastDisplayer testPlayer2 = new ForecastDisplayer(tester);

		tester.setWeather(23, 0.97, 10000);
		tester.setWeather(86, 0.93, 5000);
		WeatherStation tester2 = new WeatherStation();
		testPlayer.changeStation(tester2);
		tester.setWeather(23, 0.97, 10000);
		tester.setWeather(86, 0.93, 5000);


	}

}
