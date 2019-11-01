package pageObjects;

import java.util.List;
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
	
	@FindBy(how = How.XPATH, using =("/html/body/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/form/table/tbody/tr[1]/td[2]/select"))
	private WebElement opt_colorclick;
	
	//@FindBy(how = How.ID, using ="pa_size")
	@FindBy(how = How.XPATH, using =("/html/body/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/form/table/tbody/tr[2]/td[2]/select"))
	private WebElement opt_sizeclick;
	
	//@FindBy(how = How.ID, using ="pa_color")
	@FindBy(how = How.XPATH, using =("/html/body/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/form/table/tbody/tr[1]/td[2]/select/option[2]"))
	private WebElement opt_color;
	
	//@FindBy(how = How.ID, using ="pa_size")
	@FindBy(how = How.XPATH, using =("/html/body/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/form/table/tbody/tr[2]/td[2]/select/option[2]"))
	private WebElement opt_size;	
	
	
	public void clickOn_AddToCart() {
		btn_AddToCart.click();
	}
	
	public void select_Product(int productNumber) {
		prd_List.get(productNumber).click();
	}
	
	public void clickOn_addColor() {
		opt_colorclick.click();

	}
	
	public void select_addColor() {
				
		new Select(opt_colorclick).selectByIndex(1);
		
		//Select dropdowncolor = new Select(opt_color);
		//dropdowncolor.selectByIndex(1);

	}
	
	public void clickOn_Addsize() {
		
		opt_sizeclick.click();

	}
	
	public void select_Addsize() {
		
		new Select(opt_sizeclick).selectByIndex(1);
		//Select dropdownsize = new Select(opt_size);
		//dropdownsize.selectByIndex(1);

	}

}