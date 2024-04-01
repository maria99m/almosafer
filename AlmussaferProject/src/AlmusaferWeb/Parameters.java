package AlmusaferWeb;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parameters {

	WebDriver driver = new ChromeDriver();
	
	String theUrl= "https://www.almosafer.com/en";
	
	String [] webSites = {"https://www.almosafer.com/en" , "https://www.almosafer.com/ar"};
	
	String []  CitiesInEnglish = {"dubai", "jeddah", "riyadh"};
	Random randForcity = new Random();
	
	int randomEnglishcity = randForcity.nextInt(CitiesInEnglish.length);
	
	String []  CitiesInArabic = {"دبي", "جدة"};
	
	int randomArabicCity = randForcity.nextInt(CitiesInArabic.length);
	
	
	
	
	
}
