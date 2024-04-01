package AlmusaferWeb;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Random;

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
	
	@Test(priority = 1, enabled = false)
	public void checkTheDefaultLanguageIsEnglish() {
		
		String ExpectedLanguage = "EN";
		String Actuallanguage = driver.findElement(By.tagName("html")).getAttribute("lang").toUpperCase();
		
		assertEquals(Actuallanguage, ExpectedLanguage);
	}
	
	@Test(priority = 2, enabled = false)
	public void checkTheDefaultCurrecnyIsSAR() {
		
		String Expectedcurrency = "SAR";
		String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']")).getText();
		  System.out.println(ActualCurrency);
		assertEquals(ActualCurrency, Expectedcurrency);
	}
	
	@Test(priority = 3, enabled = false)
	public void checkContactNumber() {
		
		String ExpectedContactNumber = "+96655400000";
		String ActualContactNumber = driver.findElement(By.tagName("strong")).getText();
		  System.out.println(ActualContactNumber);
		  
		assertEquals(ExpectedContactNumber, ActualContactNumber);
	}
	
	@Test(priority = 4, enabled = false)
	public void checkQitafLogo() {
		
		WebElement theFooter = driver.findElement(By.tagName("footer"));
		theFooter.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ekulBa.eYboXF")).isDisplayed();
		  System.out.println(theFooter.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ekulBa.eYboXF")).isDisplayed());
		
		  assertEquals(theFooter.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ekulBa.eYboXF")).isDisplayed(), true);
	}
	
	@Test(priority = 5, enabled = false)
	public void checkHotelTabIsNotSelectedByDefault() {
		
		//بترجع string 
		driver.findElement(By.id("uncontrolled-tab-example-tab-hotels")).getAttribute("aria-selected");
		System.out.println(driver.findElement(By.id("uncontrolled-tab-example-tab-hotels")).getAttribute("aria-selected"));
		  
		assertEquals(driver.findElement(By.id("uncontrolled-tab-example-tab-hotels")).getAttribute("aria-selected"), "false");
	
	
	}
	
	@Test(priority = 6)
	public void checkDepatureDateAndReturnDate() {
		
		LocalDate today = LocalDate.now();
		/*System.out.println(today.getDayOfMonth());
		System.out.println(today.getDayOfYear());
	    System.out.println(today.getDayOfWeek().getValue());*/
		int expectedDepartureDate = today.plusDays(1).getDayOfMonth();
		int expectedreturnDate = today.plusDays(2).getDayOfMonth();
		
		System.out.println(expectedDepartureDate);
		System.out.println(expectedreturnDate);
		// هيك بكتب css selector 
		
		int actualDepartureDate = Integer.parseInt(driver.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-kqlzXE blwiEW'] span[class='sc-cPuPxo LiroG']"))
			.getText());
		
		int ActualReturn = Integer.parseInt(driver.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-OxbzP edzUwL'] span[class='sc-cPuPxo LiroG']"))
				.getText());
		
		assertEquals(ActualReturn, expectedreturnDate);
		
		assertEquals(actualDepartureDate, expectedDepartureDate);
		
	
	}
	
	@Test(priority = 7 , invocationCount = 8 , enabled = false)
	public void randoMethodToChangeTheLanguage() {
		
		Random rand = new Random();
		int randomIndex = rand.nextInt(webSites.length);
		 
		driver.get(webSites[randomIndex]);
		
		// هيك بتاكد الويب سايت عربي مش انجليزي  
		if(driver.getCurrentUrl().contains("ar")) {
			
			String ExpectedLang= "ar";
			
			String ActualLang = driver.findElement(By.tagName("html")).getAttribute("lang");
			
			assertEquals(ActualLang, ExpectedLang);
			
		}
		
		else {
			
            String ExpectedLang= "en";
			
			String ActualLang = driver.findElement(By.tagName("html")).getAttribute("lang");
			
			assertEquals(ActualLang, ExpectedLang);
			
			
		}
		
	
	
	}
	
	@Test(priority = 8, enabled = true)
	public void switchToHotelTab() {
		
	 //اول شي اكبس ع ال hotel tab 
	WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		HotelTab.click();
	//بدنا ندخل input للاماكن والاوتيلات 
   
	// if arabic 
   if(driver.getCurrentUrl().contains("ar")) {
	   WebElement searchcityInputA = driver.findElement(By.cssSelector("input[placeholder='البحث عن فنادق أو وجهات']']"));
	   searchcityInputA.sendKeys(CitiesInArabic);
	   
   }
   else {
	   
	   WebElement searchcityInput = driver.findElement(By.cssSelector("input[placeholder='Search for hotels or places']"));
	   searchcityInput.sendKeys(CitiesInEnglish);
	   
   }
	}
	
	
	
	
	
	
	@AfterTest
	public void myPostTest() {
		
		
	}
}
