package com.kerchanshe.tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kerchanshe.base.Base;
import com.kerchanshe.constants.Constants;
import com.kerchanshe.pages.CompanyMastersPage;
import com.kerchanshe.pages.LoginPagePage;
import com.kerchanshe.utilities.ExcelReader;
import com.kerchanshe.utilities.FakerUtility;
import com.kerchanshe.utilities.GeneralUtility;

public class CompanyMastersTest extends Base {
	LoginPagePage loginpagepage;
	CompanyMastersPage companymasterspage;
	ExcelReader excelreader;

	@Test(enabled = false)
	public void verifyAddNewAndSearchCompanyFunctionality() {
		companymasterspage = new CompanyMastersPage(driver);
		loginpagepage = new LoginPagePage(driver);
		loginpagepage.loginUtility();
		companymasterspage.clickMasters();
		companymasterspage.clickAddNewButton();
		String address = FakerUtility.getRandomAddress();
		excelreader = new ExcelReader();
		excelreader.setExcelFile("testdataKerchanshe", "companymasters");
		String companycode = excelreader.getCellData(0, 0);
		String companyname = excelreader.getCellData(0, 1);
		String contactno = excelreader.getCellData(0, 2);
		String email = excelreader.getCellData(0, 3);
		String description = excelreader.getCellData(0, 4);
		companymasterspage.addNewCompany(companycode, companyname, contactno, email, address, description);
		companymasterspage.selectContactCode();
		companymasterspage.selectCountryValue();
		companymasterspage.clickSaveButton();
		String companyName = excelreader.getCellData(0, 1);
		companymasterspage.inputSearchCompany(companyName);
		String actualSearchResult = companymasterspage.getSearchResult();
		Assert.assertEquals(actualSearchResult, Constants.EXPECTED_SEARCH_RESULT);

	}

	@Test(enabled = false)
	public void verifyNextButtonEnabled() {
		companymasterspage = new CompanyMastersPage(driver);
		loginpagepage = new LoginPagePage(driver);
		loginpagepage.loginUtility();
		companymasterspage.clickMasters();
		Boolean actualResultNextButton = companymasterspage.is_NextButtonEnabled();
		Assert.assertTrue(actualResultNextButton);

	}

	@Test(enabled = false)
	public void verifyPreviousButtonEnabled() {
		companymasterspage = new CompanyMastersPage(driver);
		loginpagepage = new LoginPagePage(driver);
		loginpagepage.loginUtility();
		companymasterspage.clickMasters();
		Boolean actualResultPreviousButton = companymasterspage.is_PreviousButtonEnabled();
		Assert.assertTrue(actualResultPreviousButton);

	}

	@Test(enabled = false)
	public void verifyDeleteFunctionality() {
		companymasterspage = new CompanyMastersPage(driver);
		loginpagepage = new LoginPagePage(driver);
		loginpagepage.loginUtility();
		companymasterspage.clickMasters();
		excelreader = new ExcelReader();
		excelreader.setExcelFile("testdataKerchanshe", "companymasters");
		String link = excelreader.getCellData(1,0);
		companymasterspage.deletecompany(link);
		companymasterspage.deleteAlertAccept();
		String companyName = excelreader.getCellData(1, 0);
		companymasterspage.inputSearchCompany(companyName);
		String actualDeleteSearchResult = companymasterspage.getDeleteSearchResult();
		Assert.assertEquals(actualDeleteSearchResult, Constants.EXPECTED_DELETE_SEARCH_RESULT);
		
	}
	@Test(enabled = false)
	public void verifyViewFunctionality() {
		companymasterspage = new CompanyMastersPage(driver);
		loginpagepage = new LoginPagePage(driver);
		loginpagepage.loginUtility();
		companymasterspage.clickMasters();
		excelreader = new ExcelReader();
		excelreader.setExcelFile("testdataKerchanshe", "companymasters");
		String companyview=excelreader.getCellData(0, 0);
		companymasterspage.viewElement(companyview);
		String actualViewPageTitle=companymasterspage.getViewPageElementText();
		Assert.assertEquals(actualViewPageTitle,Constants.EXPECTED_COMPANY_VIEW_PAGE_TITLE);
	}
	@Test(enabled = false)
	public void verifyEditFunctionality() {
		companymasterspage = new CompanyMastersPage(driver);
		loginpagepage = new LoginPagePage(driver);
		loginpagepage.loginUtility();
		companymasterspage.clickMasters();
		excelreader = new ExcelReader();
		excelreader.setExcelFile("testdataKerchanshe", "companymasters");
		String companyEdit=excelreader.getCellData(3, 0);
		companymasterspage.editCompanyDetails(companyEdit);
		String editaddress=FakerUtility.getRandomAddress();
		companymasterspage.editCompanyAddress(editaddress);
		String actualCompanyEditTitle=companymasterspage.getEditPageElementText();
		Assert.assertEquals(actualCompanyEditTitle,Constants.EXPECTED_COMPANY_EDIT_TITLE);
	}
	@Test(enabled = true)
	public void verifyDownloadFunctionality() {
		companymasterspage = new CompanyMastersPage(driver);
		loginpagepage = new LoginPagePage(driver);
		loginpagepage.loginUtility();
		companymasterspage.clickMasters();
		excelreader = new ExcelReader();
		excelreader.setExcelFile("testdataKerchanshe", "companymasters");
		String downloadCompany=excelreader.getCellData(4, 0);
		companymasterspage.downloadCompanyDetails(downloadCompany);
		String actualDownloadPageTitle=companymasterspage.getDownloadPageElementText();
		Assert.assertEquals(actualDownloadPageTitle,Constants.EXPECTED_COMPANY_DOWNLOAD_PAGE_TITLE);
		}
}
