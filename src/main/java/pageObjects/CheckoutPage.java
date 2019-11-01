package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

	public CheckoutPage(WebDriver driver) {
	     PageFactory.initElements(driver, this);
	 }
	
	@FindBy(how = How.ID, using ="billing_first_name") 
	private WebElement txtbx_FirstName;
	 
	 @FindBy(how = How.ID, using ="billing_last_name") 
	 private WebElement txtbx_LastName;
	 
	 @FindBy(how = How.CSS, using = "#billing_address_1") 
	 private WebElement txtbx_Address;
	 
	 @FindBy(how = How.CSS, using = "#billing_city") 
	 private WebElement txtbx_City;
	 
	 @FindAll(@FindBy(how = How.CSS, using = "#select2-drop ul li"))
	 private List<WebElement> country_List; 
	 
	 @FindBy(how = How.CSS, using = "#billing_postcode") 
	 private WebElement txtbx_PostCode;

	 @FindBy(how = How.CSS, using = "#billing_phone") 
	 private WebElement txtbx_Phone;

	 @FindBy(how = How.CSS, using = "#billing_email") 
	 private WebElement txtbx_Email;
	 
	 @FindBy(how = How.CSS, using = "#terms.input-checkbox") 
	 private WebElement chkbx_AcceptTermsAndCondition;
	 
	 @FindBy(how = How.CSS, using = "#place_order") 
	 private WebElement btn_PlaceOrder;
	 
	 
	 public void enter_Name(String name) {
		 txtbx_FirstName.sendKeys(name);
	 	}
	 
	 public void enter_LastName(String lastName) {
		 txtbx_LastName.sendKeys(lastName);
	 	}
	 
	 public void enter_Street(String street) {
		 txtbx_Email.sendKeys(street);
		}
 
	 public void enter_City(String city) {
		 txtbx_City.sendKeys(city);
	 	}
	 
	 public void enter_PostCode(String postCode) {
		 txtbx_PostCode.sendKeys(postCode);
	 	}
	 
	 public void enter_Phone(String phone) {
		 txtbx_Phone.sendKeys(phone);
	 	}
	 
	 public void enter_Email(String email) {
		 txtbx_Email.sendKeys(email);
	 }

	  
	 public void check_TermsAndCondition(boolean value) {
		 
		 if(value) chkbx_AcceptTermsAndCondition.click();
	 }
	 
	 public void clickOn_PlaceOrder() {
	 
		 btn_PlaceOrder.submit();
	 }
	 
	 
	 public void fill_PersonalDetails() {
		 
		 enter_Name("Aotomation");
		 enter_LastName("Test");
		 enter_Phone("0000000000");
		 enter_Email("Automation@gmail.com");
		 enter_City("Delhi");
		 enter_PostCode("110088");

	 }
	
}
