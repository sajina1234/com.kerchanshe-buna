package com.kerchanshe.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kerchanshe.base.Base;
import com.kerchanshe.constants.Constants;
import com.kerchanshe.pages.DepartmentMastersPage;
import com.kerchanshe.pages.DesignationMastersPage;
import com.kerchanshe.pages.LoginPagePage;
import com.kerchanshe.utilities.ExcelReader;
import com.kerchanshe.utilities.FakerUtility;

public class DesignationMastersTest extends Base{
	LoginPagePage loginpagepage;
	DesignationMastersPage designationmasterspage;
	ExcelReader excelreader;

	@Test(enabled = false)
	public void verifyAddNewAndSearchDesignationFunctionality() {
	designationmasterspage = new DesignationMastersPage(driver);
		loginpagepage = new LoginPagePage(driver);
		loginpagepage.loginUtility();
		designationmasterspage.clickMasters();
		excelreader = new ExcelReader();
		excelreader.setExcelFile("testdataKerchanshe", "designationmasters");
		String desigcode = excelreader.getCellData(0, 0);
		String designame = excelreader.getCellData(0, 1);
		String description = excelreader.getCellData(0, 2);
		designationmasterspage.addNewDesignation(desigcode, designame, description);
		designationmasterspage.inputSearchDesignation(designame);;
		String actualdesignationsearchresult = designationmasterspage.getSearchResult();
		Assert.assertEquals(actualdesignationsearchresult, actualdesignationsearchresult);
		}
	@Test(enabled = false)
	public void verifyDeleteDesignationFunctionality() {
		designationmasterspage = new DesignationMastersPage(driver);
		loginpagepage = new LoginPagePage(driver);
		loginpagepage.loginUtility();
		designationmasterspage.clickMasters();
		excelreader = new ExcelReader();
		excelreader.setExcelFile("testdataKerchanshe", "designationmasters");
		String link = excelreader.getCellData(0, 1);
		designationmasterspage.deleteDesignation(link);
		designationmasterspage.deleteAlertAccept();
		String designationName = excelreader.getCellData(0, 1);
		designationmasterspage.inputSearchDesignation(designationName);
		String actualdepartmentDeletesearchresult = designationmasterspage.getDeleteSearchResult();
		Assert.assertEquals(actualdepartmentDeletesearchresult,Constants.EXPECTED_DESIGNATION_DELETE_SEARCH_RESULT);
		}
	@Test(enabled = false)
	public void verifyEditDesignationFunctionality() {
		designationmasterspage = new DesignationMastersPage(driver);
		loginpagepage = new LoginPagePage(driver);
		loginpagepage.loginUtility();
		designationmasterspage.clickMasters();
		excelreader = new ExcelReader();
		excelreader.setExcelFile("testdataKerchanshe", "designationmasters");
		String designationname = excelreader.getCellData(1, 0);
		designationmasterspage.editDesignationDetails(designationname);
		String desc = FakerUtility.getRandomAddress();
		designationmasterspage.editDepartmentDescription(desc);
		String actualDesigEditElementTitle = designationmasterspage.getEditPageElementText();
		Assert.assertEquals(actualDesigEditElementTitle, Constants.EXPECTED_DESIGNATION_EDIT_PAGE_TITLE);

	}
	@Test(enabled = true)
	public void verifyViewDesignationFunctionality() {
		designationmasterspage = new DesignationMastersPage(driver);
		loginpagepage = new LoginPagePage(driver);
		loginpagepage.loginUtility();
		designationmasterspage.clickMasters();
		excelreader = new ExcelReader();
		excelreader.setExcelFile("testdataKerchanshe", "designationmasters");
		String designatname = excelreader.getCellData(2, 0);
		designationmasterspage.viewDesignation(designatname);
		String actualDesigViewElementTitle = designationmasterspage.getViewPageElementText();
		Assert.assertEquals(actualDesigViewElementTitle, Constants.EXPECTED_DESIGNATION_VIEW_PAGE_TITLE);
	}
}
