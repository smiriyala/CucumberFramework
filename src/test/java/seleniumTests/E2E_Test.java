package seleniumTests;
 

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

 
public class E2E_Test {
 
	private static WebDriver driver;
 
	 public static void main(String[] args) throws InterruptedException, IOException {
		 
		 System.setProperty("webdriver.chrome.driver","C:\\Libs\\chromedriver.exe");

		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("http://shop.demoqa.com");
		 
		 driver.navigate().to("http://shop.demoqa.com/?s=" + "dress" + "&post_type=product");
	 
		 
		 List<WebElement> items = driver.findElements(By.cssSelector(".noo-product-inner"));
		 items.get(0).click();
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500)");
		 Thread.sleep(5000);
		 
		  
		 Select dropdowncolor = new Select(driver.findElement(By.id("pa_color"))); 
		 dropdowncolor.selectByIndex(1);
		 
		 Thread.sleep(5000);
	
		 Select dropdownsize = new Select(driver.findElement(By.id("pa_size"))); 
		 dropdownsize.selectByIndex(1);
		 
		 WebElement addToCart = driver.findElement(By.cssSelector("button.single_add_to_cart_button"));
		 addToCart.click(); 
		 
		 
		 WebElement cart = driver.findElement(By.cssSelector(".cart-button"));
		 cart.click();
		 
		 WebElement continueToCheckout = driver.findElement(By.cssSelector(".checkout-button.alt"));
		 continueToCheckout.click(); 
		 
		 
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

		 WebElement acceptTC = driver.findElement(By.cssSelector("#terms.input-checkbox"));
		 acceptTC.click();
		 
		 WebElement placeOrder = driver.findElement(By.cssSelector("#place_order"));
		 placeOrder.submit();
		 
		 driver.quit();
		 
		 }									

}