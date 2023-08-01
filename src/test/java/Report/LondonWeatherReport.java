package Report;

import static io.restassured.RestAssured.*;
import java.util.Scanner;
import org.json.JSONObject;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class LondonWeatherReport 
{
	@Test
	public void getLondonWheatherInformation() 
	{
			Scanner sc = new Scanner(System.in);
		
			Response response=given()
			.when()
			.get("https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22");
			
			JSONObject jo = new JSONObject(response.asString());
			
			System.out.println("Enter Option: ");
			int option = sc.nextInt();
			
			switch (option) 
				{
				case 0:
					System.out.println("Program terminated");
					break;
					
				case 1:
					System.out.println("Enter date: ");
					String dateEnteredTemp = sc.next();
					
					System.out.println("tempreture on input date: "+dateEnteredTemp);
					  
					  for(int i = 0; i < jo.getJSONArray("list").length(); i++) 
					  {
						  	String date = response.jsonPath().get("list["+i+"].dt_txt").toString();
						  	if(date.contains(dateEnteredTemp)) 
						  	{
							  String tempreture = response.jsonPath().get("list["+i+"].main.temp").toString();
							  System.out.println(tempreture);
							}
						  	else 
						  	{
						  		System.out.println("Data is not available for provided date");
						  		break;
						  	}
					  }
					  break;
					  
				case 2:
					System.out.println("Enter date: ");
					String dateEnteredWind = sc.next();
					
					System.out.println("Wind speed on input date: "+dateEnteredWind);
					  
					  for(int i = 0; i < jo.getJSONArray("list").length(); i++) 
					  {
						  	String date = response.jsonPath().get("list["+i+"].dt_txt").toString();
						  	if(date.contains(dateEnteredWind)) 
						  	{
							  String windSpeed = response.jsonPath().get("list["+i+"].wind.speed").toString();
							  System.out.println(windSpeed);
							}
						  	else 
						  	{
						  		System.out.println("Data is not available for provided date");
						  		break;
						  	}
					  }
					  break;
					  
				case 3:
					System.out.println("Enter date: ");
					String dateEnteredPressure = sc.next();
					
					System.out.println("Pressure on input date: "+dateEnteredPressure);
					  
					  for(int i = 0; i < jo.getJSONArray("list").length(); i++) 
					  {
						  	String date = response.jsonPath().get("list["+i+"].dt_txt").toString();
						  	if(date.contains(dateEnteredPressure)) 
						  	{
							  String pressure = response.jsonPath().get("list["+i+"].main.pressure").toString();
							  System.out.println(pressure);
							}
						  	else 
						  	{
						  		System.out.println("Data is not available for provided date");
						  		break;
						  	}
					  }
					  break;
	
				default:
					System.out.println("Invalid option");
					break;
			}
	
		}
}
