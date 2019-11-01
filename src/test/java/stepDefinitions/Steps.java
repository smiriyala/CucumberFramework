package stepDefinitions;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.ProductListingPage;


public class Steps {
	
	WebDriver driver;
	HomePage home;
	ProductListingPage productListingPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	 
	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:\\tools\\Jenkins\\workspace\\cucumberFrameworkpipeline\\driver\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 
		 //Dimension d = new Dimension(1382,744); 
		//Resize the current window to the given dimension
		//driver.manage().window().setSize(d); 
		
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("http://www.shop.demoqa.com");
	}

	 @When("^he search for \"([^\"]*)\"$")
	 public void he_search_for(String product)  {
		 HomePage home = new HomePage(driver);
		 home.perform_Search(product);
	 }

	@When("^choose to buy the first item$")
	public void choose_to_buy_the_first_item() throws Throwable {
		
		ProductListingPage productListingPage = new ProductListingPage(driver);
		 productListingPage.select_Product(0);
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500)");
		 
		 productListingPage.clickOn_addColor();
		 productListingPage.clickOn_Addsize();
		 
		 productListingPage.clickOn_AddToCart(); 
		 
	}

	@When("^moves to checkout from mini cart$")
	public void moves_to_checkout_from_mini_cart() throws Throwable {
		
		CartPage cartPage = new CartPage(driver);
		cartPage.clickOn_Cart();
		cartPage.clickOn_ContinueToCheckout(); 
		
	}

	@When("^enter personal details on checkout page$")
	public void enter_personal_details_on_checkout_page() throws Throwable {
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		checkoutPage = new CheckoutPage(driver);
		checkoutPage.fill_PersonalDetails(); 
	}

	@When("^accept terms and conditions$")
	public void accept_terms_conditions() throws Throwable {
	    
		checkoutPage.check_TermsAndCondition(true);
	}

	@When("^place the order$")
	public void place_the_order() throws Throwable {
	    
		checkoutPage.clickOn_PlaceOrder();
		driver.quit();
	}

}
