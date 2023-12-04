package com.kerchanshe.utilities;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.kerchanshe.constants.Constants;



public class PageUtility {
	WebDriver driver;

	public PageUtility(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * method to click elements
	 * @param element
	 */
	public static void element_Click(WebElement element) {
		element.click();
	}

	/**
	 * method to input values to the element
	 * @param element
	 * @param value
	 */
	public static void element_SendKeys(WebElement element, String value) {
		element.sendKeys(value);
	}

	/**
	 * method to select element by index
	 * @param index
	 * @param element
	 */
	public void select_ByIndex(int index, WebElement element) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * method to select element by value
	 * @param value
	 * @param element
	 */
	public void select_ByValue(String value, WebElement element) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * method to select element by visible text
	 * @param text
	 * @param element
	 */
	public void select_ByVisibleText(String text, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * method to mouse over the element
	 * @param element
	 */
	public void action_MoveToElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	/**
	 * method to double click the element
	 * @param element
	 */
	public void action_DoubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}

	/**
	 * method to drag and drop the element
	 * @param source
	 * @param target
	 */
	public void action_DragAndDrop(WebElement source, WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).build().perform();
	}

	/**
	 * method to right click the element
	 * @param element
	 */
	public void action_RightClick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
	}

	/**
	 * method to scroll into element
	 * @param element
	 */
	public void scroll_into_view(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	/**
	 * method to click element by using javascriptexecutor
	 * @param element
	 */
	public void click_JavascriptExecutor(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	/**
	 * method to accept alert
	 */
	public void alert_Accept() {
		driver.switchTo().alert().accept();
	}

	/**
	 * method for dismiss alert
	 */
	public void alert_Dismiss() {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * method to get alertmessage
	 * @return
	 */
	public String get_AlertMessage() {
		String alerttext = driver.switchTo().alert().getText();
		return alerttext;
	}

	/**
	 * method to send alerttext
	 * @param value
	 */
	public void sendAlertText(String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public void scrollAndClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int x = 0;
		while (!is_clicked(element)) {
			js.executeScript("window.scrollBy(0," + x + ")");
			x = x + 20;

		}

	}

	public boolean is_clicked(WebElement element) {
		try {
			element.click();
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * method for file uploading
	 * 
	 * @param element
	 * @param fileName
	 */
	public void fileUpload(WebElement element, String fileName) {
		try {
			File fileupload = new File(Constants.FILE_DIRECTORY + fileName);
			element.sendKeys(fileupload.getAbsolutePath());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}



