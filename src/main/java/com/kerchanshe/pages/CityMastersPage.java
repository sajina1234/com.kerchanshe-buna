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

public class CityMastersPage {
	WebDriver driver;
	PageUtility pageutility;
	GeneralUtility generalutility;
	WaitUtility waitutility;

	public CityMastersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='ERP']")
	private WebElement erp;
	@FindBy(xpath = "//span[contains(text(),'Human Resource')]")
	private WebElement hrm;
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement masters;
	@FindBy(xpath = "//a[normalize-space()='City and SubCity']")
	private WebElement citysubcity;
	@FindBy(xpath = "//a[normalize-space()='Add New']")
	private WebElement addNewButton;
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchField;
	@FindBy(xpath = "//input[@id='citycode']")
	private WebElement cityCode;
	@FindBy(xpath = "//input[@id='cityname']")
	private WebElement cityName;
	@FindBy(xpath = "//input[@id='subcity_code']")
	private WebElement subcityCode;
	@FindBy(xpath = "//input[@id='subcity_name']")
	private WebElement subcityName;
	@FindBy(xpath = "//button[normalize-space()='Add More']")
	private WebElement addmoreButton;
	@FindBy(xpath = "//button[@id='submit1']")
	private WebElement saveButton;
	@FindBy(xpath = "//a[normalize-space()='cancel']")
	private WebElement cancelButton;
	

	@FindBy(xpath = "//tbody/tr/td")
	private WebElement searchResult;
	@FindBy(xpath = "//table[@id='example1']")
	private WebElement table;
	@FindBy(xpath = "//table[@id='example1']/tbody/tr/td[3]")
	private WebElement SerachResultCityName;
	@FindBy(xpath = "//table[@id='example1']/tbody/tr/td")
	private List<WebElement> searchResultElement;
	@FindBy(xpath = "//li[@id='example1_next']//a[@class='page-link']")
	private WebElement nextButton;
	@FindBy(xpath = "//i[@class='la la-angle-double-left']")
	private WebElement previousButton;
	@FindBy(xpath = "//table[@id='example1']/tbody/tr//button[@title='Delete']")
	private WebElement deleteElement;
	/*
	 * //table[@id='example1']/tbody/tr[0]//button[@title='Delete']
	 */
	@FindBy(xpath = "//table[@id='example1']/tbody/tr/td[3]")
	private List<WebElement> linkElements;
	@FindBy(xpath = "//button[normalize-space()='Yes']")
	private WebElement alertYes;
	@FindBy(xpath = "//table[@id='example1']/tbody/tr/td[@class='dataTables_empty']")
	private WebElement deleteSearchElement;
	@FindBy(xpath = "//table[@id='example1']/tbody/tr//i[@class='la la-eye']")
	private WebElement viewButton;
	@FindBy(xpath = "//table[@id='example1']/tbody//tr//i[@class='la la-pen']")
	private WebElement editElement;
	
	@FindBy(xpath="//input[@id='cityname']")
	private WebElement editCityName;
	@FindBy(xpath="//h5[normalize-space()='Edit City and SubCity']")
	private WebElement editPageElement;
	@FindBy(xpath="//button[@id='submit1']")
	private WebElement updateButton;
	@FindBy(xpath="//h5[normalize-space()='View City and SubCity']")
private WebElement viewPageElement;

	/**
	 * method for clicking company masters in HRM
	 */
	public void clickMasters() {
		pageutility = new PageUtility(driver);
		PageUtility.element_Click(erp);
		PageUtility.element_Click(hrm);
		pageutility.action_MoveToElement(masters);
		PageUtility.element_Click(citysubcity);
	}

	/**
	 * method to add new company
	 * 
	 * @param citycode
	 * @param cityname
	 * @param subcitycode
	 * @param subcityname
	 */
	public void addNewCity(String citycode, String cityname, String subcitycode, String subcityname)
	{

		PageUtility.element_SendKeys(cityCode, citycode);
		PageUtility.element_SendKeys(cityName, cityname);
		PageUtility.element_SendKeys(subcityCode, subcitycode);
		PageUtility.element_SendKeys(subcityName, subcityname);
		
	}

	/**
	 * method for clicking AddNew button
	 */
	public void clickAddNewButton() {
		PageUtility.element_Click(addNewButton);
	}
	
	/**
	 * method for clicking "Add More" button
	 */
public void clickAddMore()
{
	PageUtility.element_Click(addmoreButton);
}

	/**
	 * method for clicking Save button
	 */
	public void clickSaveButton() {
		PageUtility.element_Click(saveButton);

	}

	/**
	 * method for input search
	 * 
	 * @param cityName
	 */
	public void inputSearchCity(String cityName) 
	{
		waitutility = new WaitUtility(driver);
		waitutility.waitForElementToBeVisible(searchField);
		PageUtility.element_SendKeys(searchField, cityName);
		List<WebElement> searchresult = searchResultElement;
		for (WebElement element : searchresult) 
		{
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
		return generalutility.get_textOfElement(SerachResultCityName);
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
	 * method for delete city
	 * 
	 * @param link
	 */
	public void deletecity(String link) {
		generalutility = new GeneralUtility(driver);
		pageutility = new PageUtility(driver);
		int maxRetries = 3; // Maximum number of retries

		for (int attempt = 1; attempt <= maxRetries; attempt++) {
			try {
				// Locate the link elements every time before interacting with them
				List<WebElement> linkElements = driver.findElements(By.xpath("//table[@id='example1']/tbody/tr/td[3]"));

				int i;
				for (i = 1; i < linkElements.size(); i++) 
				{
					if (link.equals(generalutility.get_textOfElement(linkElements.get(i))))
					{
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
 * method for view city details
 * @param cityname
 */
	public void viewElement(String cityname) {
		generalutility = new GeneralUtility(driver);
		pageutility = new PageUtility(driver);
		int maxRetries = 3; // Maximum number of retries

		for (int attempt = 1; attempt <= maxRetries; attempt++) {
			try {
				// Locate the link elements every time before interacting with them
				List<WebElement> linkElements = driver
						.findElements(By.xpath("//table[@id='example1']/tbody/tr/td[3]"));

				int i;
				for (i = 0; i < linkElements.size(); i++) {
					if (cityname.equals(generalutility.get_textOfElement(linkElements.get(i)))) {
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
	 * method for edit city details
	 * @param cityNameEdit
	 */
	public void editCityDetails(String cityNameEdit) {
		generalutility = new GeneralUtility(driver);
		pageutility = new PageUtility(driver);
		int maxRetries = 3; // Maximum number of retries

		for (int attempt = 1; attempt <= maxRetries; attempt++) {
			try {
				// Locate the link elements every time before interacting with them
				List<WebElement> linkElements = driver
						.findElements(By.xpath("//table[@id='example1']/tbody/tr/td[3]"));

				int i;
				for (i = 0; i < linkElements.size(); i++) {
					if (cityNameEdit.equals(generalutility.get_textOfElement(linkElements.get(i)))) {
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
	/**method for editing the name of the city
	 * @param editname
	 */
public void editCityName(String editname) 
{
//PageUtility.element_SendKeys(editCityName, editname);
PageUtility.element_OverWrite(editCityName, editname);
PageUtility.element_Click(updateButton);
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
public String getViewPageElementText() 
{
	return viewPageElement.getText();
}
}