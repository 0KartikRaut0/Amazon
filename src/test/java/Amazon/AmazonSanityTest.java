package Amazon;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonSanityTest extends Implementation {

//	WebDriver driver;

	@Test(priority = 1)

	public void OpenBrowserAndHandleCaptcha() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Amazon\\Drivers\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		// Open Amazon homepage
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Navigate to the page with CAPTCHA
		driver.get("https://www.amazon.com");

		WebElement captchaField = driver.findElement(By.id("captchacharacters"));

		Scanner scanner = new Scanner(System.in);
		System.out.println("Please solve the CAPTCHA manually and press Enter to continue.");
		scanner.nextLine(); // Wait for the user to press Enter

		// Input CAPTCHA solution manually
		WebElement captchaInput = driver.findElement(By.id("captchacharacters"));
		System.out.print("Enter CAPTCHA solution: ");
		String captchaSolution = scanner.nextLine();
		captchaInput.sendKeys(captchaSolution);

		// Submit the form
		WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
		submitButton.click();

	}

	@Test(priority = 2)
	public void Searchfortheproduct() {
		//// Step 1:Search for the product

		searchForProduct("samsung s23");
	}

	@Test(priority = 3)
	public void clickonfirstproduct() {
		// Step 2: Go to the first product in the search results
		goToFirstProduct();
	}

	@Test(priority = 4)
	public void addfilter() {
		// Step 3: Select product options (color)
		selectProductOptions();
	}

	@Test(priority = 5)
	public void addcart() {
		// Step 4: Add the product to the cart
		addToCart();
	}

	@Test(priority = 6)
	public void verifycartproduct() {
		// Step 5: Verify the product was added to the cart

		verifyProductAddedToCart();
	}

	@Test(priority = 7)
	public void clickcheckout() {
		// Step 6: Proceed to checkout
		proceedToCheckout();
	}

	@Test(priority = 8)
	public void enterUsername() {
		// Step 6: Proceed to checkout
		login("+919172141965");
	}

	@Test(priority = 9)
	public void clickContinuebttn() {
		// Step 6: Proceed to checkout
		cont();
	}

	@Test(priority = 10)
	public void enterPassword() {
		// Step 6: Proceed to checkout
		password("Kartik@123");
	}

	@Test(priority = 11)
	public void clickSignIn() {
		// Step 6: Proceed to checkout
		signin();
	}

	@Test(priority = 12, enabled = false)
	public void fillInfo() {
		// Step 6: Proceed to checkout
		fillShippingDetails("kartik", "pune", "pune", "maharastra", "1234", "848111818");
	}

	@Test(priority = 13, enabled = false)
	public void useaddress() {
		useThisAddress();

	}

	@Test(priority = 14, enabled = false)
	public void paymentInfo() {
		fillPaymentDetails("2251185364455", "03/2024", "252");
	}

	@Test(priority = 15, enabled = false)
	public void placeOrder() {
		submitOrder();
	}

	@Test(priority = 16)

	public void tearof() {

		driver.quit();
	}

}
