package com.kerchanshe.tests;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.kerchanshe.base.Base;
import com.kerchanshe.constants.Constants;
import com.kerchanshe.pages.CityMastersPage;
import com.kerchanshe.pages.LoginPagePage;
import com.kerchanshe.utilities.ExcelReader;
import com.kerchanshe.utilities.FakerUtility;
import com.kerchanshe.utilities.GeneralUtility;
import com.kerchanshe.utilities.WaitUtility;

public class CityMastersTest extends Base {
	LoginPagePage loginpagepage;
	CityMastersPage citymasterspage;
	ExcelReader excelreader;

	@Test(enabled = false)
	public void verifyAddNewAndSearchCityFunctionality() {
		citymasterspage = new CityMastersPage(driver);
		loginpagepage = new LoginPagePage(driver);
		loginpagepage.loginUtility();
		citymasterspage.clickMasters();
		citymasterspage.clickAddNewButton();
		excelreader = new ExcelReader();
		excelreader.setExcelFile("testdataKerchanshe", "citysubcitymasters");
		
		String citycode = excelreader.getCellData(0, 0);
		String cityname = excelreader.getCellData(0, 1);
		String subcitycode = excelreader.getCellData(0, 2);
		String subcityname = excelreader.getCellData(0, 3);
			
		citymasterspage.addNewCity(citycode, cityname, subcitycode, subcityname);
		citymasterspage.clickAddMore();
		citymasterspage.clickSaveButton();
		String cityName = excelreader.getCellData(0, 1);
		citymasterspage.inputSearchCity(cityName);
		String actualSearchResult = citymasterspage.getSearchResult();
		Assert.assertEquals(actualSearchResult, Constants.EXPECTED_CITY_SEARCH_RESULT);

	}

	@Test(enabled = false)
	public void verifyNextButtonEnabled() 
	{
		citymasterspage = new CityMastersPage(driver);
		loginpagepage = new LoginPagePage(driver);
		loginpagepage.loginUtility();
		citymasterspage.clickMasters();
		Boolean actualResultNextButton = citymasterspage.is_NextButtonEnabled();
		Assert.assertTrue(actualResultNextButton);
	}

	@Test(enabled = false)
	public void verifyPreviousButtonEnabled() {
		citymasterspage = new CityMastersPage(driver);
		loginpagepage = new LoginPagePage(driver);
		loginpagepage.loginUtility();
		citymasterspage.clickMasters();
		
		Boolean actualResultPreviousButton = citymasterspage.is_PreviousButtonEnabled();
		Assert.assertTrue(actualResultPreviousButton);

	}

	@Test(enabled = false)
	public void verifyDeleteFunctionality()
	{
		citymasterspage = new CityMastersPage(driver);
		loginpagepage = new LoginPagePage(driver);
		loginpagepage.loginUtility();																						
		citymasterspage.clickMasters();																				
		excelreader = new ExcelReader();																			
		excelreader.setExcelFile("testdataKerchanshe", "citysubcitymasters");		
		String link = excelreader.getCellData(1,0);																
		/*citymasterspage.deletecity(link);																			
		citymasterspage.deleteAlertAccept();																		
		*/
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(link);
		driver.findElement(By.xpath("//i[@class='la la-trash-alt']")).click();
		citymasterspage.deleteAlertAccept();
		String cityName = excelreader.getCellData(1, 0);
		citymasterspage.inputSearchCity(cityName);
		
		String actualresult = driver.findElement(By.xpath("//td[@class='dataTables_empty']")).getText();	//Getting the text displayed
		Assert.assertEquals(actualresult,  Constants.EXPECTED_CITY_DELETE_SEARCH_RESULT );
		
		/* - - - - - - - - - - ORIGINAL - - - - - - - - - - - - - - - - - 
		 String cityName = excelreader.getCellData(1, 0);
		citymasterspage.inputSearchCity(cityName);
		String actualDeleteSearchResult = citymasterspage.getDeleteSearchResult();
		Assert.assertEquals(actualDeleteSearchResult, Constants.EXPECTED_CITY_DELETE_SEARCH_RESULT);
		*/
		}
	@Test(enabled = false)
	public void verifyViewFunctionality() {
		citymasterspage = new CityMastersPage(driver);
		loginpagepage = new LoginPagePage(driver);
		loginpagepage.loginUtility();
		citymasterspage.clickMasters();
		excelreader = new ExcelReader();
		excelreader.setExcelFile("testdataKerchanshe", "citysubcitymasters");
		String cityview=excelreader.getCellData(0, 1);
		citymasterspage.viewElement(cityview);
		String actualViewPageTitle=citymasterspage.getViewPageElementText();
		Assert.assertEquals(actualViewPageTitle,Constants.EXPECTED_CITY_VIEW_PAGE_TITLE);
	}
	
	@Test(enabled = false)
	public void verifyEditFunctionality() {
		citymasterspage = new CityMastersPage(driver);
		loginpagepage = new LoginPagePage(driver);
		loginpagepage.loginUtility();
		citymasterspage.clickMasters();
		excelreader = new ExcelReader();
		excelreader.setExcelFile("testdataKerchanshe", "citysubcitymasters");
		String cityEdit=excelreader.getCellData(0,1);
		citymasterspage.editCityDetails(cityEdit);
		String editname=excelreader.getCellData(2, 0);
		citymasterspage.editCityName(editname);
		String actualCityEditTitle=citymasterspage.getEditPageElementText();
		Assert.assertEquals(actualCityEditTitle,Constants.EXPECTED_CITY_EDIT_PAGE_TITLE);
	}
	
}