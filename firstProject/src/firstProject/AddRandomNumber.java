package firstProject;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddRandomNumber {
	
	WebDriver driver = new ChromeDriver();
	String TheCorrectUserName = "standard_user";
	String TheCorrectPassword = "secret_sauce";

	String TheinCorrectUserName = "standasss";
	String TheinCorrectPassword = "secssssssse";
    String TheUrl = "https://www.saucedemo.com/";
	
	@BeforeTest
	public void preTest() {
		driver.manage().window().maximize();

	}
	
	@Test(priority = 1)
	public void LoginTest() {
		
		driver.get(TheUrl);
		

		WebElement TheUserNameInput = driver.findElement(By.name("user-name"));
		TheUserNameInput.sendKeys(TheCorrectUserName);

		WebElement ThePasswordInput = driver.findElement(By.name("password"));
		ThePasswordInput.sendKeys(TheCorrectPassword);

		WebElement TheLoginButton = driver.findElement(By.name("login-button"));
		TheLoginButton.click();
	}	
	
	@Test(priority = 2)
	public void AddRandomItems() {
		// first we generate something called object from class random
		Random rand = new Random();
		// number 6 is the number that will not be taken as random so the range is 0-5
		int myRandomIndex = rand.nextInt(6);
		// you can keep printing this so you can see each time a random number between 0-5
		
		System.out.println(myRandomIndex);
		
		List <WebElement>  AddToCartButtons = driver.findElements(By.className("btn"));
		
	     for(int i=0; i < AddToCartButtons.size() ; i++) {
	    	 
	    	 AddToCartButtons.get(myRandomIndex).click();
	    	 
	     }
	}
	
	
}
