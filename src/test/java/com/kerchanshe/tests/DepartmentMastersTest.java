package com.kerchanshe.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kerchanshe.base.Base;
import com.kerchanshe.constants.Constants;

import com.kerchanshe.pages.DepartmentMastersPage;
import com.kerchanshe.pages.LoginPagePage;
import com.kerchanshe.utilities.ExcelReader;
import com.kerchanshe.utilities.FakerUtility;

public class DepartmentMastersTest extends Base {
	LoginPagePage loginpagepage;
	DepartmentMastersPage departmentmasterspage;
	ExcelReader excelreader;

	@Test(enabled = false)
	public void verifyAddNewAndSearchCompanyFunctionality() {
		departmentmasterspage = new DepartmentMastersPage(driver);
		loginpagepage = new LoginPagePage(driver);
		loginpagepage.loginUtility();
		departmentmasterspage.clickMasters();
		excelreader = new ExcelReader();
		excelreader.setExcelFile("testdataKerchanshe", "departmentmasters");
		String deptcode = excelreader.getCellData(0, 0);
		String deptname = excelreader.getCellData(0, 1);
		String description = excelreader.getCellData(0, 2);
		departmentmasterspage.addNewDepartment(deptcode, deptname, description);
		departmentmasterspage.addDepartmentHead();
		String subdept1 = excelreader.getCellData(0, 3);
		String subdept2 = excelreader.getCellData(0, 4);
		departmentmasterspage.addSubDepartment(subdept1, subdept2);
		departmentmasterspage.clickSaveButton();
		departmentmasterspage.inputSearchDepartment(deptname);
		String actualdepartmentsearchresult = departmentmasterspage.getSearchResult();
		Assert.assertEquals(actualdepartmentsearchresult, Constants.EXPECTED_DEPARTMENT_SEARCH_RESULT);
	}

	@Test(enabled = true)
	public void verifyDeleteDepartmentFunctionality() {
		departmentmasterspage = new DepartmentMastersPage(driver);
		loginpagepage = new LoginPagePage(driver);
		loginpagepage.loginUtility();
		departmentmasterspage.clickMasters();
		excelreader = new ExcelReader();
		excelreader.setExcelFile("testdataKerchanshe", "departmentmasters");
		String link = excelreader.getCellData(1, 0);
		departmentmasterspage.deleteDepartment(link);
		departmentmasterspage.deleteAlertAccept();
		String companyName = excelreader.getCellData(1, 0);
		departmentmasterspage.inputSearchDepartment(companyName);
		String actualdepartmentDeletesearchresult = departmentmasterspage.getDeleteSearchResult();
		Assert.assertEquals(actualdepartmentDeletesearchresult, Constants.EXPECTED_DEPARTMENT_DELETE_SEARCH_RESULT);
	}

	@Test(enabled = false)
	public void verifyEditFunctionality() {
		departmentmasterspage = new DepartmentMastersPage(driver);
		loginpagepage = new LoginPagePage(driver);
		loginpagepage.loginUtility();
		departmentmasterspage.clickMasters();
		excelreader = new ExcelReader();
		excelreader.setExcelFile("testdataKerchanshe", "departmentmasters");
		String departmentname = excelreader.getCellData(2, 0);
		departmentmasterspage.editDepartmentDetails(departmentname);
		String desc = FakerUtility.getRandomAddress();
		departmentmasterspage.editDepartmentDescription(desc);
		String actualEditElementTitle = departmentmasterspage.getEditPageElementText();
		Assert.assertEquals(actualEditElementTitle, Constants.EXPECTED_EDIT_ELEMENT_TITLE);

	}

	@Test(enabled = false)
	public void verifyViewFunctionality() {
		departmentmasterspage = new DepartmentMastersPage(driver);
		loginpagepage = new LoginPagePage(driver);
		loginpagepage.loginUtility();
		departmentmasterspage.clickMasters();
		excelreader = new ExcelReader();
		excelreader.setExcelFile("testdataKerchanshe", "departmentmasters");
		String departname = excelreader.getCellData(2, 0);
		departmentmasterspage.viewDepartment(departname);
		String actualViewElementTitle = departmentmasterspage.getViewPageElementText();
		Assert.assertEquals(actualViewElementTitle, Constants.EXPECTED_VIEW_PAGE_TITLE);
	}

	@Test(enabled = false)
	public void verifyNextButtonIsEnabled() {
		departmentmasterspage = new DepartmentMastersPage(driver);
		loginpagepage = new LoginPagePage(driver);
		loginpagepage.loginUtility();
		departmentmasterspage.clickMasters();
		Boolean actualResultNextButton = departmentmasterspage.is_NextButtonEnabled();
		Assert.assertTrue(actualResultNextButton);

	}

	@Test(enabled = false)
	public void verifyPreviousButtonIsEnabled() {
		departmentmasterspage = new DepartmentMastersPage(driver);
		loginpagepage = new LoginPagePage(driver);
		loginpagepage.loginUtility();
		departmentmasterspage.clickMasters();
		Boolean actualResultPreviousButton = departmentmasterspage.is_PreviousButtonEnabled();
		Assert.assertTrue(actualResultPreviousButton);

	}
}