package login;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddRandomItem {
	WebDriver driver = new ChromeDriver();

	String TheCorrectUserName = "standard_user";

	String TheCorrectPassword = "secret_sauce";
	String TheURL = "https://www.saucedemo.com/";

	@BeforeTest

	public void preTest() {
		driver.manage().window().maximize();

		driver.navigate().refresh();
		
		
	
	}
	
	@Test(priority = 1)
	public void LoginTest(){
		
		driver.get(TheURL);
		WebElement TheUserNameInput = driver.findElement(By.name("user-name"));

		WebElement ThePasswordInput = driver.findElement(By.name("password"));

		WebElement TheLoginButton = driver.findElement(By.name("login-button"));

		TheUserNameInput.sendKeys(TheCorrectUserName);

		ThePasswordInput.sendKeys(TheCorrectPassword);
		TheLoginButton.click();
		
	}
	
	@Test(priority = 2,groups = "high severity")
	public void AddRandomItem() {
		
		Random rand = new Random(); 
	
		
		int b = rand.nextInt(18,66);
	
		
		List<WebElement> AddtoCartButtons = driver.findElements(By.className("btn"));
		int myRandomIndex = rand.nextInt(AddtoCartButtons.size()); 

		for(int i = 0 ; i < AddtoCartButtons.size();i++) {
			AddtoCartButtons.get(myRandomIndex).click();
			AddtoCartButtons.get(b).click();
		}
		
		
	}
}