package myTestCaseSauceDemo;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainTestCases {

	WebDriver driver = new ChromeDriver();
	Random rand = new Random();

	String myWebSite = "https://www.saucedemo.com/";
	String UserName = "standard_user";
	String passwordInput = "secret_sauce";

	@BeforeTest

	public void MySetup() {

		driver.get(myWebSite);

		driver.manage().window().maximize();
		// driver.manage().window().minimize();
		// driver.manage().window().fullscreen();

	}

	@Test(priority = 1)

	public void Login() {

		WebElement UserNameInputField = driver.findElement(By.id("user-name"));
		WebElement PaswordeInputField = driver.findElement(By.id("password"));
		WebElement LoginBouttens = driver.findElement(By.id("login-button"));

		UserNameInputField.sendKeys(UserName);
		PaswordeInputField.sendKeys(passwordInput);
		LoginBouttens.click();

	}

	@Test(priority = 2, enabled = false)

	public void AddAllAtems() {
		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
		for (int i = 0; i < AddToCartButtons.size(); i++) {
			AddToCartButtons.get(i);
		}
	}

	@Test(priority = 2, enabled = false)

	public void AddOnlyOntherightOrLeft() {

		List<WebElement> AddOnlyOntherightOrLeft = driver.findElements(By.className("btn"));
		for (int i = 0; i < AddOnlyOntherightOrLeft.size(); i = i + 2) {
			AddOnlyOntherightOrLeft.get(i);
		}
	}

	@Test(priority = 2, enabled = false)

	public void AddCartinNamberOfItem() {

		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
		for (int i = 0; i < AddToCartButtons.size(); i = i++) {

			AddToCartButtons.get(i);

			if (i == 0 || i == 2) {
				continue;
			}
		}
	}

	@Test(priority = 2, enabled = false)

	public void AddItemThatStartWithSauce() {

		List<WebElement> ItemName = driver.findElements(By.className("inventory_item_name"));
		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));

		for (int i = 0; i < ItemName.size(); i++) {

			if (ItemName.get(i).getText().startsWith("Sauce")) {

				continue;

			}
			AddToCartButtons.get(i).click();
		}

	}

	@Test(priority = 3)

	public void AddRandomItem() {

		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
		int randomIndex = rand.nextInt(AddToCartButtons.size());

		System.out.println(randomIndex);

		// System.out.println(Math.random());
		// System.out.println(Math.floor(8.9));
		// System.out.println(Math.ceil(88.6));

		AddToCartButtons.get(randomIndex).click();

	}

	@Test(priority = 4)

	public void CheckOutProcess() {

		WebElement ShoppingCart = driver.findElement(By.className("shopping_cart_link"));
		ShoppingCart.click();

		WebElement Checkoutbutton = driver.findElement(By.id("checkout"));
		Checkoutbutton.click();
		// Array of first names

		String[] firstNames = { "Alice", "Bob", "Charlie", "Diana", "Edward" };

		int RandomFirstName = rand.nextInt(firstNames.length);

		// Array of last names
		String[] lastNames = { "Smith", "Johnson", "Williams", "Brown", "Jones" };
		int RandomLastName = rand.nextInt(lastNames.length);

		String[] postalCodes = { "12345", "67890", "54321", "98765", "11223" };
		int RandomPostalCode = rand.nextInt(postalCodes.length);

		WebElement FirstnameInput = driver.findElement(By.id("first-name"));
		WebElement LastNameInput = driver.findElement(By.id("last-name"));
		WebElement PostCodeInput = driver.findElement(By.id("postal-code"));

		FirstnameInput.sendKeys(firstNames[RandomFirstName]);
		
		LastNameInput.sendKeys(lastNames[RandomLastName]);
		PostCodeInput.sendKeys(postalCodes[RandomPostalCode]);

		WebElement ContinueButton = driver.findElement(By.id("continue"));
		ContinueButton.click();
		WebElement FinishButton = driver.findElement(By.id("finish"));
		FinishButton.click();
	}

	@AfterTest

	public void PostTesting() {
	}

}