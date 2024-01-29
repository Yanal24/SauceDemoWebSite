package login;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {

	WebDriver driver = new ChromeDriver();

	// assign value
	String TheCorrectUserName = "standard_user";

	String TheCorrectPassword = "secret_sauce";
	char myFirstLetter = 'M';

	int TheUserNameTwo = 123;
	double myHighest = 173.9;
	boolean iLoveJava = false;

	String TheURL = "https://www.saucedemo.com/";

	String TheIncorrectUserName = "layan<3";

	String TheIncorrectPassword = "iLoveJava";

	@BeforeTest

	public void preTest() {
		driver.manage().window().maximize();

	}

	@Test(enabled = false, priority = 1, invocationCount = 5 )
	public void Login() {


	}

	@Test(enabled = false)

	public void TestLogin_SadSceanrio() {
		driver.get(TheURL);
		WebElement TheUserNameInput = driver.findElement(By.name("user-name"));

		WebElement ThePasswordInput = driver.findElement(By.name("password"));

		WebElement TheLoginButton = driver.findElement(By.name("login-button"));

		TheUserNameInput.sendKeys(TheIncorrectUserName);

		ThePasswordInput.sendKeys(TheIncorrectPassword);
		TheLoginButton.click();

	}

	@Test(priority = 2, enabled = false)
	public void AddtoCarttheIncorrectWay() {

		driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.name("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.name("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		driver.findElement(By.name("add-to-cart-sauce-labs-fleece-jacket")).click();
		driver.findElement(By.name("add-to-cart-sauce-labs-onesie")).click();
		driver.findElement(By.name("add-to-cart-test.allthethings()-t-shirt-(red)")).click();

	}

	@Test(priority = 3, enabled = false)
	public void AddtoCartTheCorrectWay() throws InterruptedException {
		System.out.println(driver.findElements(By.className("btn")).size() + " found in your website");

		List<WebElement> AddtoCartButtons = driver.findElements(By.className("btn"));
		System.out.println(AddtoCartButtons.size());

		for (int i = 0; i < AddtoCartButtons.size(); i++) {

			AddtoCartButtons.get(i).click();
		}

		List<WebElement> Items_Names = driver.findElements(By.className("inventory_item_name"));

		for (int i = 0; i < Items_Names.size(); i++) {

			System.out.println(Items_Names.get(i).getText());
		}

	}

	@Test(priority = 2, enabled = false)

	public void addspecificITem() throws InterruptedException { 

		List<WebElement> AddToCartItems = driver.findElements(By.className("btn_primary"));

		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));

		for (int i = 0; i < AddToCartItems.size(); i++) {

			if (ItemsNames.get(i).getText().contains("Sauce Labs Onesie")|| ItemsNames.get(i).getText().contains("Sauce Labs Fleece Jacket")) {

				continue;
			}

			AddToCartItems.get(i).click();

		}

	}
	
	@Test(priority = 3 , invocationCount = 6 )
	public void AddRandomITem() throws InterruptedException {
		
		driver.get(TheURL);
		WebElement TheUserNameInput = driver.findElement(By.name("user-name"));

		WebElement ThePasswordInput = driver.findElement(By.name("password"));

		WebElement TheLoginButton = driver.findElement(By.name("login-button"));

		TheUserNameInput.sendKeys(TheCorrectUserName);

		ThePasswordInput.sendKeys(TheCorrectPassword);
		TheLoginButton.click();
		
		Thread.sleep(3000);
		
		
		
		Random rand = new Random(); 
		int RandomIndexILove = rand.nextInt(6); 
		
		System.out.println(RandomIndexILove);;
		
		List<WebElement> AddtoCartButtons = driver.findElements(By.className("btn_primary"));

		for(int i = 0; i < AddtoCartButtons.size(); i++) {
			
			AddtoCartButtons.get(RandomIndexILove).click();
		}
		
	}

	@AfterTest
	public void postTesting() {
	}

}