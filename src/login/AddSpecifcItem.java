package login;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddSpecifcItem {
	WebDriver driver = new ChromeDriver();

	String TheCorrectUserName = "standard_user";

	String TheCorrectPassword = "secret_sauce";
	String TheURL = "https://www.saucedemo.com/";

	@BeforeTest

	public void preTest() {
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void LoginTest() {

		driver.get(TheURL);
		WebElement TheUserNameInput = driver.findElement(By.name("user-name"));

		WebElement ThePasswordInput = driver.findElement(By.name("password"));

		WebElement TheLoginButton = driver.findElement(By.name("login-button"));

		TheUserNameInput.sendKeys(TheCorrectUserName);

		ThePasswordInput.sendKeys(TheCorrectPassword);
		TheLoginButton.click();

	}

	@Test(priority = 2, enabled = false)
	public void AddspecifcItemBasedOnTheIndex() {
		List<WebElement> AddtoCartButtons = driver.findElements(By.className("btn"));

		for (int i = 0; i < AddtoCartButtons.size(); i++) {
		
			AddtoCartButtons.get(0).click();
			AddtoCartButtons.get(1).click();
			
		}

	}

	@Test(priority = 3, enabled = false)
	public void AddSpecifcItemBasedOnTheNameOfTheItem() {
		List<WebElement> AddtoCartButtons = driver.findElements(By.className("btn"));
		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));

		for (int i = 0; i < AddtoCartButtons.size(); i++) {
			if (ItemsNames.get(i).getText().contains("Sauce Labs Fleece Jacket")) {
				AddtoCartButtons.get(i).click();
			}
		}

	}

	@Test(priority = 3,enabled = false)
	public void AddTwoItemsBasedOnTheNames() {
		List<WebElement> AddtoCartButtons = driver.findElements(By.className("btn"));
		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));

		for (int i = 0; i < AddtoCartButtons.size(); i++) {
			if (ItemsNames.get(i).getText().contains("Sauce Labs Fleece Jacket")
					|| ItemsNames.get(i).getText().contains("Sauce Labs Bolt T-Shirt")) {
				AddtoCartButtons.get(i).click();
			}
		}

	}

	
	@Test(priority = 3,enabled = false)
	public void addAllItemsExceptForOneitemOrTwo() {
		List<WebElement> AddtoCartButtons = driver.findElements(By.className("btn"));
		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));

		for (int i = 0; i < AddtoCartButtons.size(); i++) {
			if (ItemsNames.get(i).getText().contains("Sauce Labs Fleece Jacket")
					|| ItemsNames.get(i).getText().contains("Sauce Labs Bolt T-Shirt")) {
				continue ; 
			}
			
			AddtoCartButtons.get(i).click();
		}

	}
	
	@Test(priority = 3)
	public void addAllItemsAndStopAtOneItem() {
		List<WebElement> AddtoCartButtons = driver.findElements(By.className("btn"));
		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));

		for (int i = 0; i < AddtoCartButtons.size(); i++) {
			if (ItemsNames.get(i).getText().contains("Sauce Labs Fleece Jacket")) {
				break ; 
			}
			
			AddtoCartButtons.get(i).click();
		}

	}
	
}