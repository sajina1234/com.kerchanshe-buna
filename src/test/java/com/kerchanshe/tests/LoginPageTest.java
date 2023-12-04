package com.kerchanshe.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kerchanshe.base.Base;
import com.kerchanshe.constants.Constants;
import com.kerchanshe.pages.LoginPagePage;

public class LoginPageTest extends Base {
	LoginPagePage loginpage;

	@Test(enabled = true)
	public void verifyPageTitle() {
		loginpage = new LoginPagePage(driver);
		loginpage.loginUtility();
		String actualURL = loginpage.getCurrentUrl();
		Assert.assertEquals(actualURL, Constants.EXPECTED_PAGE_URL);

	}

	@Test(enabled = true)
	public void verifySignInButtonEnabled() {
		loginpage = new LoginPagePage(driver);
		boolean actualResult = loginpage.is_SignInButtonEnabled();
		Assert.assertTrue(actualResult);
	}
}