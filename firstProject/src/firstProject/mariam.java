 package firstProject;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class mariam {

	WebDriver driver = new ChromeDriver();
	String TheCorrectUserName = "standard_user";
	String TheCorrectPassword = "secret_sauce";

	String TheinCorrectUserName = "standasss";
	String TheinCorrectPassword = "secssssssse";

	@BeforeTest
	public void preTest() {
		driver.manage().window().maximize();

	}

	@Test(enabled = false)
	public void TestLogin_SadScenario() {
		driver.get("https://www.saucedemo.com/");

		WebElement TheUserNameInput = driver.findElement(By.name("user-name"));
		TheUserNameInput.sendKeys(TheinCorrectUserName);

		WebElement ThePasswordInput = driver.findElement(By.name("password"));
		ThePasswordInput.sendKeys(TheinCorrectPassword);

		WebElement TheLoginButton = driver.findElement(By.name("login-button"));
		TheLoginButton.click();

	}

	@Test(enabled = true,priority =1)
	public void TestLogin_HappyScenario() {
		driver.get("https://www.saucedemo.com/");

		WebElement TheUserNameInput = driver.findElement(By.name("user-name"));
		TheUserNameInput.sendKeys(TheCorrectUserName);

		WebElement ThePasswordInput = driver.findElement(By.name("password"));
		ThePasswordInput.sendKeys(TheCorrectPassword);

		WebElement TheLoginButton = driver.findElement(By.name("login-button"));
		TheLoginButton.click();

	}

	@AfterTest
	public void postTesting() {
		// driver.close();
	}
	
	@Test(priority =2,enabled=false)
	public void AddtoCarttheIncorrectWay() {
		
		driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.name("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.name("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		driver.findElement(By.name("add-to-cart-sauce-labs-fleece-jacket")).click();
		driver.findElement(By.name("add-to-cart-sauce-labs-onesie")).click() ;
		driver.findElement(By.name("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
		
		
		
	}
	
	@Test(priority= 3, enabled=true)
	public void AddtocartthecorrectWay() throws InterruptedException {
		
		System.out.print(driver.findElements(By.className("btn")).size());
		
		 List<WebElement> AddtocartButtons = driver.findElements(By.className("btn"));
		 System.out.println(AddtocartButtons.size());
		 
		 for(int i=0; i<AddtocartButtons.size(); i++ ) {
			
			 AddtocartButtons.get(i).click();
			 Thread.sleep(2000);
		 }
		 
		 
		 List<WebElement> items_names = driver.findElements(By.className("inventory_item_name"));
	     
		 for(int i=0; i<items_names.size() ; i++) {
			 
		 System.out.println(items_names.get(i).getText());
		 
	     }
	}

	
	@Test(priority = 2, enabled = false)
	public void addSpecificItems() throws InterruptedException {
		 
		//Thread.sleep(2000);  //اذا كان النت بطيء ما عم تتحمل العناصر   
		
		List <WebElement> AddToCartItems = driver.findElements(By.className("btn_primary"));
		
		List <WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));
		 
		//System.out.println(ItemsNames.size());
		  
		for(int i=0; i < AddToCartItems.size(); i++  ) {
			
	         if(ItemsNames.get(i).getText().contains("Sauce Labs Onesie") || ItemsNames.get(i).getText().contains("Sauce Labs Fleece Jacket")) {
	        	  continue;
	         }
	         
	         
			AddToCartItems.get(i).click();
			
		}
		
	}


   @Test(priority = 3 , enabled = true , invocationCount = 5)
    public void AddRandomItems() {
	   
	   Random rand = new Random();
	   int RandomIndex = rand.nextInt(6);
	   System.out.println(RandomIndex);
	   
	   List <WebElement> AddToCartItems = driver.findElements(By.className("btn"));
	   
	   for(int i=0; i < AddToCartItems.size(); i++  ) {
	      
		   AddToCartItems.get(RandomIndex).click(); 
	   
	   }
	
      }
   }
