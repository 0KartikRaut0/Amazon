package Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Implementation {

	WebDriver driver;
	WebDriverWait wait;

	// Method to search for a product
	public void searchForProduct(String productName) {
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBox.sendKeys(productName);
		searchBox.submit();
	}

	public void notification() {

		WebElement note = driver.findElement(By.xpath(
				"//span[@class='a-button a-spacing-top-base a-button-base glow-toaster-button glow-toaster-button-dismiss']"));
		note.click();
	}

	// Method to click the first product in the search results
	public void goToFirstProduct() {
		WebElement firstProduct = driver
				.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		firstProduct.click();
	}

	// Method to select product options (if available)
	public void selectProductOptions() {
		// Assume color/size options are available; modify these as necessary
		try {
			WebElement colorOption = driver.findElement(By.id("color_name_0"));
			colorOption.click();
		} catch (Exception e) {
			System.out.println("No color option available, skipping.");
		}
	}

	// Method to add the product to the cart
	public void addToCart() {
		WebElement addToCartButton = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
		// wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
		try {
			addToCartButton.click();
		} catch (Exception e) {
			addToCartButton = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
			addToCartButton.click();
		}
	}

	// Method to verify the product was added to the cart
	public void verifyProductAddedToCart() {
		WebElement cartConfirmation = driver.findElement(By.xpath("//h1[contains(text(), 'Added to Cart')]"));
		Assert.assertTrue(cartConfirmation.isDisplayed(), "Product was not added to the cart.");
	}

	// Method to proceed to the checkout page
	public void proceedToCheckout() {
		WebElement proceedToCheckoutButton = driver.findElement(By.name("proceedToRetailCheckout"));
		proceedToCheckoutButton.click();
	}

	public void login(String user) {

		WebElement username = driver.findElement(By.xpath("//input[@type='email']"));

		username.sendKeys(user);

	}

	public void cont() {

		WebElement con = driver.findElement(By.xpath("//input[@id='continue']"));
		con.click();
	}

	public void password(String pass) {

		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));

		password.sendKeys(pass);
	}

	public void signin() {

		WebElement sin = driver.findElement(By.xpath("//input[@id='signInSubmit']"));

		sin.click();
	}

	// Method to fill in shipping details
	public void fillShippingDetails(String name, String address, String city, String state, String zipCode,
			String phone) {
		WebElement nameField = driver.findElement(By.id("address-ui-widgets-enterAddressFullName"));
		WebElement addressField = driver.findElement(By.id("address-ui-widgets-enterAddressLine1"));
		WebElement cityField = driver.findElement(By.id("address-ui-widgets-enterAddressCity"));
		WebElement stateDropdown = driver
				.findElement(By.id("address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId"));
		WebElement zipCodeField = driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode"));
		WebElement phoneField = driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber"));

		nameField.sendKeys(name);
		addressField.sendKeys(address);
		cityField.sendKeys(city);
		stateDropdown.sendKeys(state);
		zipCodeField.sendKeys(zipCode);
		phoneField.sendKeys(phone);
	}

	// Method to use the entered shipping address
	public void useThisAddress() {
		WebElement useThisAddressButton = driver.findElement(By.name("shipToThisAddress"));
		useThisAddressButton.click();
	}

	// Method to fill in payment details
	public void fillPaymentDetails(String cardNumber, String expiryDate, String cvv) {
		WebElement cardNumberField = driver.findElement(By.id("addCreditCardNumber"));
		WebElement cardExpiryField = driver.findElement(By.id("pp-Qi3TYn-99")); // Example, update based on actual page
		WebElement cardCVVField = driver.findElement(By.id("addCreditCardVerificationNumber"));

		cardNumberField.sendKeys(cardNumber);
		cardExpiryField.sendKeys(expiryDate);
		cardCVVField.sendKeys(cvv);
	}

	// Optional method to submit the order

	public void submitOrder() {

		// WebElement submitOrderButton =
		// driver.findElement(By.id("submitOrderButton"));
		// submitOrderButton.click();
	}

}
