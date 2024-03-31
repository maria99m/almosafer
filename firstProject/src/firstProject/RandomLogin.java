package firstProject;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class RandomLogin {

	WebDriver driver = new ChromeDriver();
	//WebDriver driver1 = new EdgeDriver();
	
	@BeforeTest
	public void mySetup() {
		
	}
	
	@Test(invocationCount = 10,enabled = true, priority = 1)
	public void LoginUsingDifferentUserNames() throws InterruptedException {
		
		String [] UserNames = {"standard_user", "locked_out_user","problem_user","performance_glitch_user","error_user","visual_user"};
		//String Passwords [] = {"1", "mmmdmm", "lll33", "kkkkkk4kk","llllld"} ;
		Random rand = new Random();
		System.out.println(rand.nextInt(UserNames.length));
		
		driver.get("https://www.saucedemo.com/");
	    
		WebElement UserNameInputField = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
	   WebElement PasswordInputField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
	   WebElement LoginButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
	   
	   String theUser = UserNames[rand.nextInt(UserNames.length)];
	   String commonPassword = "secret_sauce";
	   
	  // UserNameInputField.sendKeys(UserNames[0]);
	   UserNameInputField.sendKeys(theUser);
	   // اذا كان لل login كتر من باسوورد 
	  /* if(theUser.equals("standard_user") ) {
		   PasswordInputField.sendKeys("123");
	  } */
	   
	  // PasswordInputField.sendKeys(Passwords[rand.nextInt(UserNames.length)]);
	   PasswordInputField.sendKeys(commonPassword);
	   LoginButton.click();
	   Thread.sleep(3000);
	   
	   driver.manage().window().maximize();
	   
	   List <WebElement>  AddToCartButtons = driver.findElements(By.className("btn"));
	   
	   //System.out.println(AddToCartButtons.size());
	   for (int i = 0; i< AddToCartButtons.size(); i++) {
		   AddToCartButtons.get(i).click();
	   }
	   
	   int expecteditemAsNumber =  AddToCartButtons.size();
     //  String expecteditemAsText = Integer.toString(expecteditemAsNumber);
	   
	   String actualitem = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]")).getText();
	   //مشان اتاكد التيست نجح او فشل 
	   //ا بزبط اقارن نص مع رقم   
	   int actualitemAsNumber = Integer.parseInt(actualitem);
	   
	   //assertEquals(actualitemAsNumber, expecteditemAsNumber);
	 
	}
	
	@Test(enabled = true ,priority = 2)
	public void thePriceOfTheFirstTwoItems() {
		
	/* String myname = "ahmad";
	System.out.println(myname.toLowerCase().charAt(0));
	System.out.println(myname.contains("n"));
	System.out.println(myname.endsWith("g"));  
	System.out.println(myname.concat("  mariam")); */
		
	List<WebElement> prices  = driver.findElements(By.className("inventory_item_price"));
		
	for( int i=0 ; i< prices.size(); i++) {
			
	String  first_item_price = prices.get(i).getText().replace("$", " ");
	String  second_item_price = prices.get(i).getText().replace("$", " ");
		
	double PriceOne = Double.parseDouble("first_item_price");
	double PriceTwo = Double.parseDouble("second_item_price");
	
	double expectedPrice = 39.98;
	double actualPrice = PriceOne + PriceTwo;
	
	    assertEquals(actualPrice, expectedPrice);
		}
		
	}
	
	
	
	
}
