package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class Steps {
	
	WebDriver driver;
	
	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:\\Libs\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("http://www.shop.demoqa.com");
	}

	@When("^he search for dress$")
	public void he_search_for_dress() throws Throwable {
		driver.navigate().to("http://shop.demoqa.com/?s=" + "dress" + "&post_type=product");
	}

	@When("^choose to buy the first item$")
	public void choose_to_buy_the_first_item() throws Throwable {
		
		 List<WebElement> items = driver.findElements(By.cssSelector(".noo-product-inner"));
		 items.get(0).click();
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500)");
		 Thread.sleep(5000);
		 
		  
		 Select dropdowncolor = new Select(driver.findElement(By.id("pa_color"))); 
		 dropdowncolor.selectByIndex(1);
		 
		 
	
		 Select dropdownsize = new Select(driver.findElement(By.id("pa_size"))); 
		 dropdownsize.selectByIndex(1);
		 Thread.sleep(5000);
		 
		 WebElement addToCart = driver.findElement(By.cssSelector("button.single_add_to_cart_button"));
		 addToCart.click(); 
	}

	@When("^moves to checkout from mini cart$")
	public void moves_to_checkout_from_mini_cart() throws Throwable {
		
		WebElement cart = driver.findElement(By.cssSelector(".cart-button"));
		cart.click();
		 
		WebElement continueToCheckout = driver.findElement(By.cssSelector(".checkout-button.alt"));
		continueToCheckout.click(); 
	}

	@When("^enter personal details on checkout page$")
	public void enter_personal_details_on_checkout_page() throws Throwable {
		
		Thread.sleep(5000);
		 WebElement firstName = driver.findElement(By.cssSelector("#billing_first_name"));
		 firstName.sendKeys("Lakshay");
		 
		 WebElement lastName = driver.findElement(By.cssSelector("#billing_last_name"));
		 lastName.sendKeys("Sharma");
		 
		 WebElement street = driver.findElement(By.id("billing_address_1"));
		 street.sendKeys("2nd street");
		 
		 WebElement town = driver.findElement(By.id("billing_city"));
		 town.sendKeys("London");
		 
		 WebElement postcode = driver.findElement(By.cssSelector("#billing_postcode"));
		 postcode.sendKeys("RM11 2NP"); 
		 
		 WebElement emailAddress = driver.findElement(By.cssSelector("#billing_email"));
		 emailAddress.sendKeys("test@gmail.com");
		 
		 WebElement phone = driver.findElement(By.cssSelector("#billing_phone"));
		 phone.sendKeys("07438862327");
		 
	}

	@When("^accept terms and conditions$")
	public void select_same_delivery_address() throws Throwable {
	    
		 WebElement acceptTC = driver.findElement(By.cssSelector("#terms.input-checkbox"));
		 acceptTC.click();
	}

	@When("^place the order$")
	public void place_the_order() throws Throwable {
	    
		 WebElement placeOrder = driver.findElement(By.cssSelector("#place_order"));
		 placeOrder.submit();
	}

}
