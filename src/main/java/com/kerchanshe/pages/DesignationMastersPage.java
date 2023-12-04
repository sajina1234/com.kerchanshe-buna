package com.kerchanshe.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kerchanshe.utilities.GeneralUtility;
import com.kerchanshe.utilities.PageUtility;
import com.kerchanshe.utilities.WaitUtility;

public class DesignationMastersPage {
	WebDriver driver;
	PageUtility pageutility;
	GeneralUtility generalutility;
	WaitUtility waitutility;

	public DesignationMastersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[text()='ERP']")
	private WebElement erp;
	@FindBy(xpath = "//span[contains(text(),'Human Resource')]")
	private WebElement hrm;
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement masters;
	@FindBy(xpath = "//a[normalize-space()='Designation']")
	private WebElement designation;
	@FindBy(xpath = "//a[normalize-space()='Add New']")
	private WebElement addNewButton;
	@FindBy(xpath = "//input[@id='descode']")
	private WebElement designationCode;
	@FindBy(xpath="//input[@id='desname']")
	private WebElement designationName;
	@FindBy(xpath="//textarea[@id='desdesc']")
	private WebElement designationDescription;
	@FindBy(xpath="//button[@id='submit1']")
	private WebElement saveButton;
	@FindBy(xpath="//input[@id='searchByName']")
	private WebElement searchButton;
	@FindBy(xpath="//td//i[@class='la la-eye']")
	private WebElement viewButton;
	@FindBy(xpath="//td//i[@class='la la-pen']")
	private WebElement editButton;
	@FindBy(xpath="//td//i[@class='la la-trash-alt']")
	private WebElement deleteButton;
	@FindBy(xpath = "//table['designation_example']/tbody/tr/td[3]")
	private List<WebElement> linkElement;
	@FindBy(xpath = "//table[@id='example']/tbody/tr/td")
	private List<WebElement> searchResultElement;
	@FindBy(xpath = "//table['designation_example']/tbody/tr/td[3]")
	private WebElement searchResultDesigName;
	@FindBy(xpath="//button[normalize-space()='Yes']")
	private WebElement alertYes;
	@FindBy(xpath="//textarea[@id='desdesc']")
	private WebElement editDescription;
	@FindBy(xpath="//h5[normalize-space()='Edit Designation']")
	private WebElement editPageElement;
	@FindBy(xpath="//h5[normalize-space()='View Designation']")
	private WebElement viewElementTitle;
	@FindBy(xpath="//td[@class='dataTables_empty']")
	private WebElement deleteResult;
	/**
	 * method for clicking designation masters in HRM
	 */
	public void clickMasters() {
		pageutility = new PageUtility(driver);
		PageUtility.element_Click(erp);
		PageUtility.element_Click(hrm);
		pageutility.action_MoveToElement(masters);
		PageUtility.element_Click(designation);
	}
	public void addNewDesignation(String desigcode, String designame,String description) {
        clickAddNewButton();
		PageUtility.element_SendKeys(designationCode, desigcode);
		PageUtility.element_SendKeys(designationName, designame);
		PageUtility.element_SendKeys(designationDescription, description);
		clickSaveButton();
	
	}
	/**
	 * method for click AddNew button
	 */
	public void clickAddNewButton() {
		PageUtility.element_Click(addNewButton);
	}
	/**
	 * method for click save button
	 */
	public void clickSaveButton() {
		PageUtility.element_Click(saveButton);
	}
	/** method for input search designation
	 * @param designationName
	 */
	public void inputSearchDesignation(String designationName) {

		waitutility = new WaitUtility(driver);
		waitutility.waitForElementToBeVisible(searchButton);
		PageUtility.element_SendKeys(searchButton, designationName);
		List<WebElement> searchresult = searchResultElement;
		for (WebElement element : searchresult) {
			String print = element.getText();
			System.out.println(print);

		}
	}
	/**
	 * method for getting search result
	 * @return
	 */
	public String getSearchResult() {
		generalutility = new GeneralUtility(driver);
		return generalutility.get_textOfElement(searchResultDesigName);
	}
	/**
	 * mathod for delete designation
	 * @param link
	 */
	public void deleteDesignation(String link) {
		generalutility = new GeneralUtility(driver);
		pageutility = new PageUtility(driver);
		int maxRetries = 3; // Maximum number of retries

		for (int attempt = 1; attempt <= maxRetries; attempt++) {
			try {
				// Locate the link elements every time before interacting with them
				List<WebElement> linkElements = driver
						.findElements(By.xpath("//table['designation_example']/tbody/tr/td[3]"));

				int i;
				for (i = 0; i < linkElements.size(); i++) {
					if (link.equals(generalutility.get_textOfElement(linkElements.get(i)))) {
						i++; // Incrementing the index before breaking out of the loop
						break;
					}
				}

				// Re-find the delete button element before clicking it
				WebElement deleteElement = driver.findElement(By.xpath("//tr[" + i + "]//i[@class='la la-trash-alt']"));
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
	public String getDeleteSearchResult() {
		return deleteResult.getText();
	}
	/**
	 * method for edit designation details
	 * @param DepartmentNameEdit
	 */
	public void editDesignationDetails(String DepartmentNameEdit) {
		generalutility = new GeneralUtility(driver);
		pageutility = new PageUtility(driver);
		int maxRetries = 3; // Maximum number of retries

		for (int attempt = 1; attempt <= maxRetries; attempt++) {
			try {
				// Locate the link elements every time before interacting with them
				List<WebElement> linkElements = driver
						.findElements(By.xpath("//table['designation_example']/tbody/tr/td[3]"));

				int i;
				for (i = 0; i < linkElements.size(); i++) {
					if (DepartmentNameEdit.equals(generalutility.get_textOfElement(linkElements.get(i)))) {
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
	/**
	 * method for edit department description
	 * @param desc
	 */
	public void editDepartmentDescription(String desc) {
		PageUtility.element_SendKeys(editDescription, desc);
	}
	/**
	 * method for getting title of edit page
	 * @return
	 */
	public String getEditPageElementText() {
		return editPageElement.getText();
	}
	/**
	 * method for view designation details
	 * @param designame
	 */
	public void viewDesignation(String designame) {
		generalutility = new GeneralUtility(driver);
		pageutility = new PageUtility(driver);
		int maxRetries = 3; // Maximum number of retries

		for (int attempt = 1; attempt <= maxRetries; attempt++) {
			try {
				// Locate the link elements every time before interacting with them
				List<WebElement> linkElements = driver
						.findElements(By.xpath("//table['designation_example']/tbody/tr/td[3]"));

				int i;
				for (i = 0; i < linkElements.size(); i++) {
					if (designame.equals(generalutility.get_textOfElement(linkElements.get(i)))) {
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
	/*
	 * method for getting title of view page
	 */

	public String getViewPageElementText() {
		return viewElementTitle.getText();
	}
	}
