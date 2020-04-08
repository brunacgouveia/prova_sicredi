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

public class CustomerListPage {
	
	@FindBy(id="switch-version-select")
	private WebElement cmbVersion;
	
	@FindBy(xpath="//option[@value='bootstrap_theme_v4']")
	private WebElement optionV4;
	
	@FindBy(xpath="//a[contains(@href,'add')]")
	private WebElement btnAddCustomer;
	
	@FindBy(name="customerName")
	private WebElement txtSearchName;
	
	@FindBy(className="select-all-none")
	private WebElement ckbSelectAllCustomers;	
	
	@FindBy(xpath="//a[@title='Delete']")
	private WebElement btnDelete;
	
	@FindBy(xpath="//div[contains(@class,'delete') and contains(@style,'display: block;')]//div[@class='modal-footer']/button[contains(@class,'delete-multiple-confirmation-button')]")
	private WebElement btnDeletePopup;
		
	private WebDriverWait wait;	
	
	
	public CustomerListPage() {
		WebDriver driver = DriverFactory.getDriver();
		wait = new WebDriverWait(driver, 1);
		PageFactory.initElements(driver, this);
	}
	
	public void selectVersion4() {
		cmbVersion.click();
		optionV4.click();
		
		wait.withTimeout(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@action='/demo/bootstrap_theme_v4']")));
		
		DriverFactory.waitForMilliseconds(2000);
	}
	
	public void clickAddCustomerButton() {
		btnAddCustomer.click();
	}

	public void searchForName(String name) {
		txtSearchName.clear();
		txtSearchName.sendKeys(name);
		
		DriverFactory.waitForMilliseconds(3000);
	}	
	
	public void selectCustomer() {
		ckbSelectAllCustomers.click();
	}
	
	public void clickDeleteButton() {
		btnDelete.click();
		
		String xpath = "//div[contains(@class,'delete-multiple-confirmation') and contains(@style,'display: block;')]//div[@class='modal-body']/p[contains(text(),'Are you sure that you want to delete this 1 item?')]";
		wait.withTimeout(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));		
	}	
		
	public void confirmDeletionCustomerPopup() {
		btnDeletePopup.click();
	}

	public boolean validateMessageCustomerDeleted() {
		try {
			wait.withTimeout(Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-growl='message']/p[text()='Your data has been successfully deleted from the database.']")));
			return true;
	    }
	    catch(TimeoutException error) {
	    	return false;
	    }
	}	
	
	public boolean isCustomerListingPage() {
		try {
			wait.withTimeout(Duration.ofSeconds(1));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='gcrud-search-form']")));
			return true;
	    }
	    catch(TimeoutException error) {
	    	return false;
	    }
	}
}
