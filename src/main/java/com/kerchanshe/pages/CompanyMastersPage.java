package com.kerchanshe.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kerchanshe.utilities.GeneralUtility;
import com.kerchanshe.utilities.PageUtility;
import com.kerchanshe.utilities.WaitUtility;

public class CompanyMastersPage {
	WebDriver driver;
	PageUtility pageutility;
	GeneralUtility generalutility;
	WaitUtility waitutility;

	public CompanyMastersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='ERP']")
	private WebElement erp;
	@FindBy(xpath = "//span[contains(text(),'Human Resource')]")
	private WebElement hrm;
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement masters;
	@FindBy(xpath = "//a[text()='Company']")
	private WebElement company;
	@FindBy(xpath = "//a[@class='btn btn-sm btn-primary btn-st']")
	private WebElement addNewButton;
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchField;
	@FindBy(xpath = "//input[@id='txtcode']")
	private WebElement companyCode;
	@FindBy(xpath = "//input[@id='txtname']")
	private WebElement companyName;
	@FindBy(xpath = "//span[text()='Select']")
	private WebElement countryDropDown;
	@FindBy(xpath = "//select[@name='phone_code']")
	private WebElement contactNoCode;
	@FindBy(xpath = "//input[@id='phone_number']")
	private WebElement contactNo;
	@FindBy(xpath = "//input[@id='company_email']")
	private WebElement companyEmail;
	@FindBy(xpath = "//textarea[@id='company_address']")
	private WebElement companyAddress;
	@FindBy(xpath = "//textarea[@id='description']")
	private WebElement descriptionText;
	@FindBy(xpath = "//button[@id='submit1']")
	private WebElement saveButton;
	@FindBy(xpath = "//select/option")
	private WebElement countryDroplist;
	@FindBy(xpath = "//li[16]//label[1]")
	private WebElement countryValue;

	@FindBy(xpath = "//table[@id='company_tbl']/tbody/tr/td")
	private WebElement searchResult;
	@FindBy(xpath = "//table[@id='company_tbl']")
	private WebElement table;
	@FindBy(xpath = "//table[@id='company_tbl']/tbody/tr/td[3]")
	private WebElement SerachResultCompanyName;
	@FindBy(xpath = "//table[@id='company_tbl']/tbody/tr/td")
	private List<WebElement> searchResultElement;
	@FindBy(xpath = "//li[@id='company_tbl_next']//a[@class='page-link']")
	private WebElement nextButton;
	@FindBy(xpath = "//li[@id='company_tbl_previous']")
	private WebElement previousButton;
	@FindBy(xpath = "//table[@id='company_tbl']/tbody/tr//button[@title='Delete']")
	private WebElement deleteElement;
	@FindBy(xpath = "//table[@id='company_tbl']/tbody/tr/td[3]")
	private List<WebElement> linkElements;
	@FindBy(xpath = "//button[normalize-space()='Yes']")
	private WebElement alertYes;
	@FindBy(xpath = "//table[@id='company_tbl']/tbody/tr/td[@class='dataTables_empty']")
	private WebElement deleteSearchElement;
	@FindBy(xpath = "//table[@id='company_tbl']/tbody/tr//i[@class='la la-eye']")
	private WebElement viewButton;
	@FindBy(xpath = "//table[@id='company_tbl']/tbody///tr//i[@class='la la-pen']")
	private WebElement editElement;
	@FindBy(xpath="//textarea[@id='company_address']")
	private WebElement editCompanyAddress;
	@FindBy(xpath="//h5[normalize-space()='Edit Company']")
	private WebElement editPageElement;
	@FindBy(xpath="//h5[normalize-space()='View Company']")
private WebElement viewPageElement;
	@FindBy(xpath="//h5[normalize-space()='Company Payroll']")
	private WebElement downloadPageElement;
	/**
	 * method for clicking company masters in HRM
	 */
	public void clickMasters() {
		pageutility = new PageUtility(driver);
		PageUtility.element_Click(erp);
		PageUtility.element_Click(hrm);
		pageutility.action_MoveToElement(masters);
		PageUtility.element_Click(company);
	}

	/**
	 * method to add new company
	 * 
	 * @param companycode
	 * @param companyname
	 * @param contactno
	 * @param email
	 * @param address
	 * @param description
	 */
	public void addNewCompany(String companycode, String companyname, String contactno, String email, String address,
			String description) {

		PageUtility.element_SendKeys(companyCode, companycode);
		PageUtility.element_SendKeys(companyName, companyname);
		PageUtility.element_SendKeys(contactNo, contactno);
		PageUtility.element_SendKeys(companyEmail, email);
		PageUtility.element_SendKeys(companyAddress, address);
		PageUtility.element_SendKeys(descriptionText, description);
	}

	/**
	 * method for click AddNew button
	 */
	public void clickAddNewButton() {
		PageUtility.element_Click(addNewButton);
	}

	/**
	 * method for clicking Save button
	 */
	public void clickSaveButton() {
		PageUtility.element_Click(saveButton);

	}

	/**
	 * method for selecting contact code value
	 */
	public void selectContactCode() {
		PageUtility.element_Click(contactNoCode);
		pageutility.select_ByValue("1", contactNoCode);
	}

	/**
	 * method for selecting country value
	 */
	public void selectCountryValue() {
		PageUtility.element_Click(countryDropDown);
		PageUtility.element_Click(countryValue);

	}

	/**
	 * method for input search
	 * 
	 * @param companyName
	 */
	public void inputSearchCompany(String companyName) {

		waitutility = new WaitUtility(driver);
		waitutility.waitForElementToBeVisible(searchField);
		PageUtility.element_SendKeys(searchField, companyName);
		List<WebElement> searchresult = searchResultElement;
		for (WebElement element : searchresult) {
			String print = element.getText();
			System.out.println(print);

		}
	}

	/**
	 * method for getting search result
	 * 
	 * @return
	 */
	public String getSearchResult() {
		generalutility = new GeneralUtility(driver);
		return generalutility.get_textOfElement(SerachResultCompanyName);
	}

	/**
	 * method for checking next button is enable or not
	 * 
	 * @return
	 */
	public boolean is_NextButtonEnabled() {
		generalutility = new GeneralUtility(driver);
		return generalutility.is_enabled(nextButton);
	}

	/**
	 * method for checking previous button is enable or not
	 * 
	 * @return
	 */
	public boolean is_PreviousButtonEnabled() {
		generalutility = new GeneralUtility(driver);
		return generalutility.is_enabled(previousButton);
	}

	/**
	 * method for click delete button
	 */
	public void clickDeleteButton() {

		PageUtility.element_Click(deleteElement);
	}

	/**
	 * method for delete company
	 * 
	 * @param link
	 */
	public void deletecompany(String link) {
		generalutility = new GeneralUtility(driver);
		pageutility = new PageUtility(driver);
		int maxRetries = 3; // Maximum number of retries

		for (int attempt = 1; attempt <= maxRetries; attempt++) {
			try {
				// Locate the link elements every time before interacting with them
				List<WebElement> linkElements = driver
						.findElements(By.xpath("//table[@id='company_tbl']/tbody/tr/td[3]"));

				int i;
				for (i = 0; i < linkElements.size(); i++) {
					if (link.equals(generalutility.get_textOfElement(linkElements.get(i)))) {
						i++; // Incrementing the index before breaking out of the loop
						break;
					}
				}

				// Re-find the delete button element before clicking it
				WebElement deleteElement = driver.findElement(By.xpath("//tr[" + i + "]//button[@title='Delete']"));
				deleteElement.click();

				// Break out of the loop if the deletion is successful
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Stale Element Reference Exception. Retrying...");

				// Add any additional wait or delay if needed
				try {
					Thread.sleep(1000);
				} catch (InterruptedException sleepException) {
					Thread.currentThread().interrupt();
				}
			}
		}
	}

	/**
	 * method for accept delete
	 */
	public void deleteAlertAccept() {
		PageUtility.element_Click(alertYes);
	}

	/**
	 * method for get delete search result
	 * 
	 * @return
	 */
	public String getDeleteSearchResult() {
		return deleteSearchElement.getText();

	}
/**
 * method for view company details
 * @param companyname
 */
	public void viewElement(String companyname) {
		generalutility = new GeneralUtility(driver);
		pageutility = new PageUtility(driver);
		int maxRetries = 3; // Maximum number of retries

		for (int attempt = 1; attempt <= maxRetries; attempt++) {
			try {
				// Locate the link elements every time before interacting with them
				List<WebElement> linkElements = driver
						.findElements(By.xpath("//table[@id='company_tbl']/tbody/tr/td[3]"));

				int i;
				for (i = 0; i < linkElements.size(); i++) {
					if (companyname.equals(generalutility.get_textOfElement(linkElements.get(i)))) {
						i++; // Incrementing the index before breaking out of the loop
						break;
					}
				}

				// Re-find the delete button element before clicking it
				WebElement viewButton = driver.findElement(By.xpath("//tr[" + i + "]//i[@class='la la-eye']"));
				viewButton.click();

				// Break out of the loop if the deletion is successful
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Stale Element Reference Exception. Retrying...");

				// Add any additional wait or delay if needed
				try {
					Thread.sleep(1000);
				} catch (InterruptedException sleepException) {
					Thread.currentThread().interrupt();
				}
			}
		}

	}
	/**
	 * method for edit company details
	 * @param companyNameEdit
	 */
	public void editCompanyDetails(String companyNameEdit) {
		generalutility = new GeneralUtility(driver);
		pageutility = new PageUtility(driver);
		int maxRetries = 3; // Maximum number of retries

		for (int attempt = 1; attempt <= maxRetries; attempt++) {
			try {
				// Locate the link elements every time before interacting with them
				List<WebElement> linkElements = driver
						.findElements(By.xpath("//table[@id='company_tbl']/tbody/tr/td[3]"));

				int i;
				for (i = 0; i < linkElements.size(); i++) {
					if (companyNameEdit.equals(generalutility.get_textOfElement(linkElements.get(i)))) {
						i++; // Incrementing the index before breaking out of the loop
						break;
					}
				}

				// Re-find the delete button element before clicking it
				WebElement editElement = driver.findElement(By.xpath("//tr[" + i + "]//i[@class='la la-pen']"));
				editElement.click();

				// Break out of the loop if the deletion is successful
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Stale Element Reference Exception. Retrying...");

				// Add any additional wait or delay if needed
				try {
					Thread.sleep(1000);
				} catch (InterruptedException sleepException) {
					Thread.currentThread().interrupt();
				}
			}
		}
	}
	/**method for edit companyaddress
	 * @param editaddress
	 */
public void editCompanyAddress(String editaddress) {
PageUtility.element_SendKeys(editCompanyAddress, editaddress);
}
/**
 * method for downloading company details
 * @param companyName
 */
public void downloadCompanyDetails(String companyName) {
	generalutility = new GeneralUtility(driver);
	pageutility = new PageUtility(driver);
	int maxRetries = 3; // Maximum number of retries

	for (int attempt = 1; attempt <= maxRetries; attempt++) {
		try {
			// Locate the link elements every time before interacting with them
			List<WebElement> linkElements = driver
					.findElements(By.xpath("//table[@id='company_tbl']/tbody/tr/td[3]"));

			int i;
			for (i = 0; i < linkElements.size(); i++) {
				if (companyName.equals(generalutility.get_textOfElement(linkElements.get(i)))) {
					i++; // Incrementing the index before breaking out of the loop
					break;
				}
			}

			// Re-find the delete button element before clicking it
			WebElement downloadButton = driver.findElement(By.xpath("//tr[" + i + "]//i[@class='la la-cloud-upload-alt']"));
			downloadButton.click();

			// Break out of the loop if the deletion is successful
			break;
		} catch (StaleElementReferenceException e) {
			System.out.println("Stale Element Reference Exception. Retrying...");

			// Add any additional wait or delay if needed
			try {
				Thread.sleep(1000);
			} catch (InterruptedException sleepException) {
				Thread.currentThread().interrupt();
			}
		}
	}
}
/**
 * method for getting text from editpage element
 * @return
 */
public String getEditPageElementText() {
	return editPageElement.getText();
}
/**
 * method for getting text from viewpage element
 * @return
 */
public String getViewPageElementText() {
	return viewPageElement.getText();
}
/**
 * method for getting text from downloadpage element
 * @return
 */
public String getDownloadPageElementText() {
	return downloadPageElement.getText();
}
}
