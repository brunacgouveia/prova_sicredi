package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverFactory;

public class CustomerAddPage {

	@FindBy(id="field-customerName")
	private WebElement txtName;
	
	@FindBy(id="field-contactLastName")
	private WebElement txtLastName;
	
	@FindBy(id="field-contactFirstName")
	private WebElement txtContactFirstName;
	
	@FindBy(id="field-phone")
	private WebElement txtPhone;
	
	@FindBy(id="field-addressLine1")
	private WebElement txtAddressLine1;	
	
	@FindBy(id="field-addressLine2")
	private WebElement txtAddressLine2;
	
	@FindBy(id="field-city")
	private WebElement txtCity;
	
	@FindBy(id="field-state")
	private WebElement txtState;
	
	@FindBy(id="field-postalCode")
	private WebElement txtPostalCode;
	
	@FindBy(id="field-country")
	private WebElement txtCountry;
	
	@FindBy(id="field_salesRepEmployeeNumber_chosen")
	private WebElement cmbFromEmployeer;
	
	@FindBy(xpath="//div[@id='field_salesRepEmployeeNumber_chosen']//input")
	private WebElement txtFromEmployeer;
	
	@FindBy(xpath="//div[@id='field_salesRepEmployeeNumber_chosen']//li[contains(@class,'active-result')]")
	private WebElement lnkFromEmployeer;
	
	@FindBy(id="field-creditLimit")
	private WebElement txtCreditLimit;
	
	@FindBy(id="form-button-save")
	private WebElement btnSave;
	
	@FindBy(xpath="//div[@id='report-success']//a[text()='Go back to list']")
	private WebElement lnkGoBackToList;
		
	private WebDriverWait wait;	
	
	
	public CustomerAddPage() {
		WebDriver driver = DriverFactory.getDriver();
		wait = new WebDriverWait(driver, 1);
		PageFactory.initElements(driver, this);
	}

	public void setName(String name) {
		txtName.clear();
		txtName.sendKeys(name);
	}
	
	public void setLastName(String lastName) {
		txtLastName.clear();
		txtLastName.sendKeys(lastName);
	}
	
	public void setContactFirstName(String contactFirstName) {
		txtContactFirstName.clear();
		txtContactFirstName.sendKeys(contactFirstName);
	}
	
	public void setPhone(String phone) {
		txtPhone.clear();
		txtPhone.sendKeys(phone);
	}
	
	public void setAddressLine1(String addressLine1) {
		txtAddressLine1.clear();
		txtAddressLine1.sendKeys(addressLine1);
	}
	
	public void setAddressLine2(String addressLine2) {
		txtAddressLine2.clear();
		txtAddressLine2.sendKeys(addressLine2);
	}
	
	public void setCity(String city) {
		txtCity.clear();
		txtCity.sendKeys(city);
	}
	
	public void setState(String state) {
		txtState.clear();
		txtState.sendKeys(state);
	}
	
	public void setPostalCode(String postalCode) {
		txtPostalCode.clear();
		txtPostalCode.sendKeys(postalCode);
	}
	
	public void setCountry(String country) {
		txtCountry.clear();
		txtCountry.sendKeys(country);
	}
	
	public void setFromEmployeer(String fromEmployeer) {
		cmbFromEmployeer.click();
		txtFromEmployeer.sendKeys(fromEmployeer);
		lnkFromEmployeer.click();
	}
	
	public void setCreditLimit(String creditLimit) {
		txtCreditLimit.clear();
		txtCreditLimit.sendKeys(creditLimit);
	}
	
	public void clickSaveButton() {
		btnSave.click();
	}
	
	public boolean validateMessageCustomerAdded() {
		try {
			wait.withTimeout(Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='report-success']/p[contains(text(),'Your data has been successfully stored into the database.')]")));
			return true;
	    }
	    catch(TimeoutException error) {
	    	return false;
	    }		
	}
	
	public boolean isCustomerAdditionPage() {
		try {
			wait.withTimeout(Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='crudForm']")));
			return true;
	    }
	    catch(TimeoutException error) {
	    	return false;
	    }
	}
	
	public void goBackToList() {
		lnkGoBackToList.click();
	}	
	
}
