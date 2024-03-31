package firstProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddEvenNumber {
	
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
	public void AddEvenNumberItem() {
		
		List <WebElement> AddToCartItems = driver.findElements(By.className("btn"));
		   
		   for(int i=1; i < AddToCartItems.size(); i+=2  ) {
		      
			   AddToCartItems.get(i).click(); 
		   
		   }
		
		
	}

}
