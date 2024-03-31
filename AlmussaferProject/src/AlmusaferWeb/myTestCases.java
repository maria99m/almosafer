package AlmusaferWeb;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestCases extends Parameters {

	
	@BeforeTest
	public void mySstup() {
		driver.get(theUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	
		WebElement popUpScreen = driver.findElement(By.className("sc-iBmynh"));
	      
		  if(popUpScreen.isDisplayed()) {
			  //best Practice always (هون بعرفهم مابصير بالكلاس التاني )
	    	WebElement sarButton = driver.findElement(By.className("cta__saudi"));
	    	sarButton.click();
	    }
		
	
	}
	
	@Test(priority = 1)
	public void checkTheDefaultLanguageIsEnglish() {
		
		String ExpectedLanguage = "EN";
		String Actuallanguage = driver.findElement(By.tagName("html")).getAttribute("lang").toUpperCase();
		
		assertEquals(Actuallanguage, ExpectedLanguage);
	}
	
	@Test(priority = 2)
	public void checkTheDefaultCurrecnyIsSAR() {
		
		String Expectedcurrency = "SAR";
		String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']")).getText();
		  System.out.println(ActualCurrency);
		assertEquals(ActualCurrency, Expectedcurrency);
	}
	
	@Test(priority = 3)
	public void checkContactNumber() {
		
		String ExpectedContactNumber = "+96655400000";
		String ActualContactNumber = driver.findElement(By.tagName("strong")).getText();
		  System.out.println(ActualContactNumber);
		  
		assertEquals(ExpectedContactNumber, ActualContactNumber);
	}
	
	@Test(priority = 4)
	public void checkQitafLogo() {
		
		WebElement theFooter = driver.findElement(By.tagName("footer"));
		theFooter.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ekulBa.eYboXF")).isDisplayed();
		  System.out.println();
		
	}
	
	
	
	@AfterTest
	public void myPostTest() {
		
		
	}
}
