package login;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class RandomLogin {

	WebDriver driver = new ChromeDriver();
	String [] UserNames = { "standard_user", "locked_out_user", "problem_user", "performance_glitch_user", "error_user",
			"visual_user" };

	Random rand = new Random();

	@BeforeTest
	public void mySetup() {
	}

	@Test(priority = 1)
	public void LoginUsingDifferentUserNames() throws InterruptedException {

		System.out.println(rand.nextInt(UserNames.length));

		driver.get("https://www.saucedemo.com/");
		WebElement UserNameInputField = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
		WebElement PasswordInputField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement LoginButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));

		String theUser = UserNames[rand.nextInt(UserNames.length)];

		String CommonPassword = "secret_sauce";
		UserNameInputField.sendKeys(theUser);
		PasswordInputField.sendKeys(CommonPassword);
		LoginButton.click();

		driver.manage().window().maximize();

		List<WebElement> AddTocartButtons = driver.findElements(By.className("btn"));

		for (int i = 0; i < AddTocartButtons.size(); i++) {
			AddTocartButtons.get(i).click();
		}

		int expecteditemAsNumber = AddTocartButtons.size();
//		String expectedItemAsText = Integer.toString(expecteditemAsNumber); 

		String actualitem = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();

		int actualitemAsNumber = Integer.parseInt(actualitem);

		assertEquals(actualitemAsNumber, expecteditemAsNumber);

	}
	@Test (priority = 2) 
	public void TheAmountOfTheFirstTwoItems(){
List <WebElement> Prices= driver.findElements(By.className("inventory_item_price"));
for(int i = 0 ; i < Prices.size() ; i++) {
	String first_item_price = Prices.get(0).getText().replace("$", "");
	String second_item_price = Prices.get(1).getText().replace("$", "");
	
	double priceOne = Double.parseDouble(first_item_price);
	double priceTwo = Double.parseDouble(second_item_price);
	double ExpectedPrice = 39.98 ;
	double ActualPrice = priceOne + priceTwo ;
    assertEquals(ActualPrice, ExpectedPrice);
}

	}
}
	
