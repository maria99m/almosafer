package v_jan_new;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class login {
	
	WebDriver driver = new ChromeDriver();
	
	@BeforeTest
	public void mySetup() {
		
	}
	
	 @Test
	 public void myFirstTest () {
		 
	driver.get("http://127.0.0.1:5500/pro.html");
			
	driver.switchTo().alert().accept();
	//System.out.println(driver.switchTo().alert().getText());
	
	System.out.println(driver.findElement(By.tagName("li")).getText());
	
	List<String> mycolors = new ArrayList <String>();
	mycolors.add("blue");
	mycolors.add("red");
	
	//System.out.println(mycolors.get(1));
	
	List <WebElement> TheMaleStudents = driver.findElements(By.className("male-student"));
	 
	System.out.println(TheMaleStudents.get(0).getText());
	System.out.println(TheMaleStudents.get(1).getText());
	
	List <WebElement> ThefeMaleStudents = driver.findElements(By.className("female-student")); 
	System.out.println(ThefeMaleStudents.get(0).getText());
	System.out.println(ThefeMaleStudents.get(1).getText());
	 
	 }
	 
	  
	
	
	

}
