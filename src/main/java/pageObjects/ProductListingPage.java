package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductListingPage {
	
	public ProductListingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.CSS, using = "button.single_add_to_cart_button") 
	private WebElement btn_AddToCart;
	
	@FindAll(@FindBy(how = How.CSS, using = ".noo-product-inner"))
	private List<WebElement> prd_List;	
	
	//@FindBy(how = How.ID, using ="pa_color")
	@FindBy(how = How.XPATH, using ="//*[@id=\"pa_color\"]")
	private WebElement opt_color;
	
	//@FindBy(how = How.ID, using ="pa_size")
	@FindBy(how = How.XPATH, using ="//*[@id=\"pa_size\"]")
	private WebElement opt_size;	
	
	
	public void clickOn_AddToCart() {
		btn_AddToCart.click();
	}
	
	public void select_Product(int productNumber) {
		prd_List.get(productNumber).click();
	}
	
	public void clickOn_addColor() {
		opt_color.click();
		Select dropdowncolor = new Select(opt_color);
		dropdowncolor.selectByIndex(1);
		
		//Select dropdowncolor = new Select(opt_color); 
		//dropdowncolor.selectByVisibleText("White");
	}
	
	public void clickOn_Addsize() {
		opt_size.click();
		Select dropdownsize = new Select(opt_size);
		dropdownsize.selectByIndex(1);
		
		//new Select(driver.findElement(By.xpath("(//select[@name='years'])[3]"))).selectByVis‌​ibleText("Mai");
		
		//Select dropdownsize = new Select(opt_size); 
		//dropdownsize.selectByVisibleText("Medium");
	}

}