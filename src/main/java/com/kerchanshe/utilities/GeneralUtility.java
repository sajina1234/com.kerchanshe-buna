package com.kerchanshe.utilities;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.kerchanshe.constants.Constants;



public class GeneralUtility {
	WebDriver driver;

	public GeneralUtility(WebDriver driver) {
		this.driver = driver;

	}

	/**
	 * method to get text of the element
	 * 
	 * @param element
	 * @return string
	 */

	public String get_textOfElement(WebElement element) {
		return element.getText();
	}

	/**
	 * method to get text of list of elements
	 * 
	 * @param listOfElements
	 * @return list<string>
	 */
	public List<String> GetTextOfElements(List<WebElement> listOfElements) {
		List<String> texts = new ArrayList<String>();
		for (WebElement elements : listOfElements) {
			String datas = elements.getText();
			texts.add(datas);
		}
		return texts;
	}

	/**
	 * method to check element is displayed
	 * 
	 * @param element
	 * @return boolean
	 */
	public boolean is_Displayed(WebElement element) {
		return element.isDisplayed();
	}

	/**
	 * method to check element is enabled
	 * 
	 * @param element
	 * @return boolean
	 */
	public boolean is_enabled(WebElement element) {
		return element.isEnabled();
	}

	/**
	 * method to check element is selected
	 * 
	 * @param element
	 * @return boolean
	 */
	public boolean is_selected(WebElement element) {
		return element.isSelected();

	}

	/**
	 * method to get attribute of the element
	 * 
	 * @param element
	 * @param attributeName
	 * @return
	 */
	public String get_Attribute(WebElement element, String attributeName) {
		return element.getAttribute(attributeName);

	}

	/**
	 * method to get css properties of element
	 * 
	 * @param element
	 * @param cssValue
	 * @return
	 */
	public String get_CssValue(WebElement element, String cssValue) {
		return element.getCssValue(cssValue);
	}

	/**
	 * method to switch window
	 */
	public void switch_Window(String windowid) {
		driver.switchTo().window(windowid);
	}

	/**
	 * method for file uploading
	 * 
	 * @param element
	 * @param fileName
	 */
	public void fileUpload(WebElement element, String fileName) {
		File fileupload = new File(Constants.FILE_DIRECTORY + fileName + ".jpeg");
		element.sendKeys(fileupload.getAbsolutePath());

	}

	/**
	 * method to get time stamp
	 * 
	 * @return
	 */
	public static String getTimeStamp() {
		return new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
	}

	/**
	 * method to get response code
	 * 
	 * @param url
	 * @return
	 */
	public int getResponseStatusCode(String url) {
		int responseCode = 0;
		HttpURLConnection huc = null;
		try {
			huc = (HttpURLConnection) (new URL(url).openConnection());
			huc.setRequestMethod("HEAD");

			huc.connect();
			responseCode = huc.getResponseCode();

		} catch (Exception e) {

		}
		return responseCode;
	}
	/**
	 * method to generate random numbers
	 * @return
	 */
	public static int getRandomNumbers() {
		Random randomGenerator = new Random();
        int number=0;
        for(int i=1;i<=10;i++) {
        	number=randomGenerator.nextInt(6);
        	
        }
        return number;
	}

	
}
	

		



