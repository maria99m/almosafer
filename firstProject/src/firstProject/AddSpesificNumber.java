package firstProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddSpesificNumber {
	
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
	
	@Test(priority = 2 , enabled = false)
	public void AddSpecificItemBasedOnTheIndex() {
		
		List <WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
		   
		   for(int i=1; i < AddToCartButtons.size(); i++ ) {
		      // first item 
			   AddToCartButtons.get(0).click(); 
		   
			   // second item 
			   AddToCartButtons.get(1).click(); 
		   }
		   }
		   
	@Test(priority = 3 , enabled = false)
	public void AddSpecificItemBasedOnTheNameOfTheItem() {
				//اخدت ال buttons 
	List <WebElement>  AddToCartButtons = driver.findElements(By.className("btn"));
	
	List <WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));
	
	for(int i=1; i < AddToCartButtons.size(); i++ ) {
		
		if(ItemsNames.get(i).getText().contains("Sauce Labs Fiece Jacket")) {
			
			AddToCartButtons.get(i).click();
			
		}		   
				   }
	
}
	
	@Test(priority = 4 , enabled = false)
	public void AddTwoItemsBasedOnTheNameOfTheItem() {
				//اخدت ال buttons 
	List <WebElement>  AddToCartButtons = driver.findElements(By.className("btn"));
	
	List <WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));
	
	for(int i=1; i < AddToCartButtons.size(); i++ ) {
		
		if(ItemsNames.get(i).getText().contains("Sauce Labs Fiece Jacket") || ItemsNames.get(i).getText().contains("Sauce Labs Bolt T-Shirt")) {
			
			AddToCartButtons.get(i).click();
			
		}		   
				   }
	}
	@Test(priority = 5 , enabled = true)
	public void AddAllItemsExceptForOne() {
				//اخدت ال buttons 
	List <WebElement>  AddToCartButtons = driver.findElements(By.className("btn"));
	
	List <WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));
	
	for(int i=1; i < AddToCartButtons.size(); i++ ) {
		
		if(ItemsNames.get(i).getText().contains("Sauce Labs Fiece Jacket") 
				|| ItemsNames.get(i).getText().contains("Sauce Labs Bolt T-Shirt")) {
			continue;
		
		}		   
		AddToCartButtons.get(i).click();	
	}
	}
	
	@Test(priority = 5 , enabled = true)
	public void AddAllItemsAndStopOneItem() {
				//اخدت ال buttons 
	List <WebElement>  AddToCartButtons = driver.findElements(By.className("btn"));
	
	List <WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));
	
	for(int i=1; i < AddToCartButtons.size(); i++ ) {
		
		if(ItemsNames.get(i).getText().contains("Sauce Labs Fiece Jacket") 
				|| ItemsNames.get(i).getText().contains("Sauce Labs Bolt T-Shirt")) {
			break;
		
		}		   
		AddToCartButtons.get(i).click();	
	}
	}
	
	}
