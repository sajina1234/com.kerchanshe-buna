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

public class DepartmentMastersPage {
	WebDriver driver;
	PageUtility pageutility;
	GeneralUtility generalutility;
	WaitUtility waitutility;

	public DepartmentMastersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[text()='ERP']")
	private WebElement erp;
	@FindBy(xpath = "//span[contains(text(),'Human Resource')]")
	private WebElement hrm;
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement masters;
	@FindBy(xpath="//a[normalize-space()='Department']")
	private WebElement department;
	@FindBy(xpath="//a[normalize-space()='Add New']")
	private WebElement addNewButton;
	@FindBy(xpath="//input[@type='search']")
	private WebElement searchButton;
	@FindBy(xpath="//li[@id='example_previous']")
	private WebElement previousButton;
	@FindBy(xpath="//li[@id='example_next']//a[@class='page-link']")
	private WebElement nextButton;
	@FindBy(xpath="//input[@id='depcode']")
	private WebElement deptCode;
	@FindBy(xpath="//input[@id='depname']")
	private WebElement deptName;
	@FindBy(xpath="//span[@class='placeholder']")
	private WebElement deptHead;
	@FindBy(xpath="//textarea[@id='depdescription']")
	private WebElement deptDescription;
	@FindBy(xpath="//input[@id='subdepartment']")
	private WebElement deptSub;
	@FindBy(xpath="//button[normalize-space()='Add More']")
	private WebElement addMoreButton;
	@FindBy(xpath="//button[@id='submit1']")
	private WebElement saveButton;
	@FindBy(xpath="//li[7]//label[1]")
	private WebElement deptHeadElement;
	@FindBy(xpath="//tr//i[@class='la la-eye']")
	private WebElement viewButton;
	@FindBy(xpath="//tr//i[@class='la la-pen']")
	private WebElement editButton;
	@FindBy(xpath="//tr//i[@class='la la-trash-alt']")
	private WebElement deleteButton;
	@FindBy(xpath = "//table[@id='example']/tbody/tr/td[3]")
	private WebElement searchResultDeptName;
	@FindBy(xpath = "//table[@id='example']/tbody/tr/td[3]")
	private List<WebElement> linkElement;
	@FindBy(xpath = "//table[@id='example']/tbody/tr/td")
	private List<WebElement> searchResultElement;
	@FindBy(xpath="//button[normalize-space()='Yes']")
	private WebElement alertYes;
	@FindBy(xpath="//textarea[@id='depdescription']")
	private WebElement editDescription;
	@FindBy(xpath="//h5[normalize-space()='Edit Department']")
	private WebElement editPageElement;
	@FindBy(xpath="//h5[normalize-space()='View Department']")
	private WebElement viewElementTitle;
	@FindBy(xpath="//td[@class='dataTables_empty']")
	private WebElement deleteSearchResult;
	/**
	 * method for clicking department masters in HRM
	 */
	public void clickMasters() {
		pageutility = new PageUtility(driver);
		PageUtility.element_Click(erp);
		PageUtility.element_Click(hrm);
		pageutility.action_MoveToElement(masters);
		PageUtility.element_Click(department);
	}
	public void addNewDepartment(String deptcode, String deptname,String description) {
         clickAddNewButton();
		PageUtility.element_SendKeys(deptCode, deptcode);
		PageUtility.element_SendKeys(deptName, deptname);
		PageUtility.element_SendKeys(deptDescription, description);
	
	}
	/**
	 * method for click AddNew button
	 */
	public void clickAddNewButton() {
		PageUtility.element_Click(addNewButton);
	}
	/**method for input depthead
	 */
public void addDepartmentHead() {
	PageUtility.element_Click(deptHead);
	PageUtility.element_Click(deptHeadElement);
}
/**
 * method for input sub departments
 * @param sub1
 * @param sub2
 */
public void addSubDepartment(String sub1,String sub2)
{
	PageUtility.element_SendKeys(deptSub,sub1);
	clickAddMoreButton();
	PageUtility.element_SendKeys(deptSub, sub2);
	clickAddMoreButton();
	
	}
/**
 * method for click Addmore button
 */
public void clickAddMoreButton() {
	PageUtility.element_Click(addMoreButton);
}
/**
 * method for click save button
 */
public void clickSaveButton() {
	PageUtility.element_Click(saveButton);
}
/**
 * method for seraching department
 * @param departmentName
 */
public void inputSearchDepartment(String departmentName) {

	waitutility = new WaitUtility(driver);
	waitutility.waitForElementToBeVisible(searchButton);
	PageUtility.element_SendKeys(searchButton, departmentName);
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
	return generalutility.get_textOfElement(searchResultDeptName);
}
public void deleteDepartment(String link) {
	generalutility = new GeneralUtility(driver);
	pageutility = new PageUtility(driver);
	int maxRetries = 3; // Maximum number of retries

	for (int attempt = 1; attempt <= maxRetries; attempt++) {
		try {
			// Locate the link elements every time before interacting with them
			List<WebElement> linkElements = driver
					.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));

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
/**
 * method for edit department details
 * @param DepartmentNameEdit
 */
public void editDepartmentDetails(String DepartmentNameEdit) {
	generalutility = new GeneralUtility(driver);
	pageutility = new PageUtility(driver);
	int maxRetries = 3; // Maximum number of retries

	for (int attempt = 1; attempt <= maxRetries; attempt++) {
		try {
			// Locate the link elements every time before interacting with them
			List<WebElement> linkElements = driver
					.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));

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
public void viewDepartment(String departmentname) {
	generalutility = new GeneralUtility(driver);
	pageutility = new PageUtility(driver);
	int maxRetries = 3; // Maximum number of retries

	for (int attempt = 1; attempt <= maxRetries; attempt++) {
		try {
			// Locate the link elements every time before interacting with them
			List<WebElement> linkElements = driver
					.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));

			int i;
			for (i = 0; i < linkElements.size(); i++) {
				if (departmentname.equals(generalutility.get_textOfElement(linkElements.get(i)))) {
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
/**
 * method for checking nextbutton is enable or not
 * @return
 */
public boolean is_NextButtonEnabled() {
	generalutility = new GeneralUtility(driver);
	return generalutility.is_enabled(nextButton);
}
/**
 * method for checking previous button is enabled or not
 * @return
 */
public boolean is_PreviousButtonEnabled() {
	generalutility = new GeneralUtility(driver);
	return generalutility.is_enabled(previousButton);
}
public String getDeleteSearchResult() {
	return deleteSearchResult.getText();
}
}
