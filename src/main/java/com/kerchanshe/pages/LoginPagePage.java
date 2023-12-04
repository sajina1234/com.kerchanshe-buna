package com.kerchanshe.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kerchanshe.constants.Constants;
import com.kerchanshe.utilities.GeneralUtility;
import com.kerchanshe.utilities.PageUtility;
import com.kerchanshe.utilities.WaitUtility;




public class LoginPagePage {
	WebDriver driver;
	Properties properties = new Properties();
	FileInputStream fileinputstream;
	GeneralUtility generalutility;
	WaitUtility waitutility;
	 public LoginPagePage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			try {
				fileinputstream = new FileInputStream(Constants.CONFIG_FILE_PATH);
				properties.load(fileinputstream);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	@CacheLookup
	@FindBy(xpath = "//input[@id='email_id']")
	private WebElement usernameElement;
	@CacheLookup
	@FindBy(xpath = "//input[@id='psd']")
	private WebElement passwordElement;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitButton;
    @FindBy(xpath="//button[normalize-space()='Verify']")
    private WebElement verifyButton;
  @FindBy(xpath="//input[@id='otp_number']")
  private WebElement inputOTP;
	/**
	 * method to enter username
	 * @param userName
	 */
	public void enterUserName(String userName) {
		PageUtility.element_SendKeys(usernameElement, userName);
	}

	/**
	 * method to enter password
	 * @param password
	 */
	public void enterPassword(String password) {
		PageUtility.element_SendKeys(passwordElement, password);
	}

/**
 *method to click submit button
 */
	public void clickSubmitButton() {
	PageUtility.element_Click(submitButton);
		}
	/**
	 * method to enter OTP
	 * @param OTP
	 */
	public void enterOTP(String OTP) {
		PageUtility.element_SendKeys(inputOTP, OTP);
	}
	/**
	 *method to click verify button
	 */
		public void clickVerifyButton() {
		PageUtility.element_Click(verifyButton);
			}

	/**
	 * method for login
	 * @param userName
	 * @param password
	 */

	public void loginUtility(String userName, String password,String OTP) {
		enterUserName(userName);
		enterPassword(password);
		clickSubmitButton();
		enterOTP(OTP);
		clickVerifyButton();
	}

	/**
	 * method for login without parameters
	 */
	public void loginUtility() {
		String userName = properties.getProperty("username");
		String password = properties.getProperty("password");
		String OTP=properties.getProperty("OTP");
		enterUserName(userName);
		enterPassword(password);
		clickSubmitButton();
		enterOTP(OTP);
		clickVerifyButton();

	}

	/**
	 * method for checking signIn button is enabled
	 * @return boolean
	 */
	public boolean is_SignInButtonEnabled() {
		generalutility = new GeneralUtility(driver);
		return generalutility.is_enabled(submitButton);

	}
	/**
	 * method for get current URL
	 * @return
	 */
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
		
	}
	
	
}


