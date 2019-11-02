package stepDefinitions;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.ProductListingPage;


public class Steps {
	
	WebDriver driver;
	HomePage homePage;
	ProductListingPage productListingPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	PageObjectManager pageObjectManager;
	 
	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		
		//System.setProperty("webdriver.chrome.driver","C:\\Libs\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","C:\\libs\\geckodriver.exe");

		driver= new FirefoxDriver();
		
		 //driver = new ChromeDriver();
		driver.manage().window().maximize();
		 
		 //Dimension d = new Dimension(1382,744); 
		//Resize the current window to the given dimension
		//driver.manage().window().setSize(d); 
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.shop.demoqa.com");
		pageObjectManager = new PageObjectManager(driver);
		homePage = pageObjectManager.getHomePage();
		homePage.navigateTo_HomePage();	
	}

	 @When("^he search for \"([^\"]*)\"$")
	 public void he_search_for(String product)  {
		 
		 homePage.perform_Search(product);
	 }

	@When("^choose to buy the first item$")
	public void choose_to_buy_the_first_item() throws Throwable {
		
		 productListingPage = pageObjectManager.getProductListingPage();
		 productListingPage.select_Product(0);
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500)");
		 
		 //productListingPage.clickOn_addColor();
		 driver.findElement(By.id("pa_color")).click();
		 
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 //productListingPage.select_addColor();
		 
		 Select drpcolor = new Select(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/form/table/tbody/tr[1]/td[2]/select")));
		 drpcolor.selectByIndex(1);
		 
		 
		 //productListingPage.clickOn_Addsize();
		 driver.findElement(By.id("pa_size")).click();
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 //productListingPage.select_Addsize();
		 
		 Select drpsize = new Select(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/form/table/tbody/tr[2]/td[2]/select")));
		 drpsize.selectByIndex(1);
		 
		 
		 productListingPage.clickOn_AddToCart(); 
		 
	}

	@When("^moves to checkout from mini cart$")
	public void moves_to_checkout_from_mini_cart() throws Throwable {
		
		cartPage = pageObjectManager.getCartPage();
		
		cartPage.clickOn_Cart();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		 
		cartPage.clickOn_ContinueToCheckout(); 
		
	}

	@When("^enter personal details on checkout page$")
	public void enter_personal_details_on_checkout_page() throws Throwable {
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		checkoutPage = pageObjectManager.getCheckoutPage();
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
