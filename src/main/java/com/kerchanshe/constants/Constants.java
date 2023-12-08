package com.kerchanshe.constants;

public class Constants {
	public static final String CONFIG_FILE_PATH=System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties";
public static final String EXCEL_FILE_PATH=System.getProperty("user.dir")+"\\src\\main\\resources\\ExcelFiles\\";
public static final String EXTENT_REPORT_FILEPATH=System.getProperty("user.dir")+"\\ExtentReports";
public static final String FILE_DIRECTORY=System.getProperty("user.dir")+"\\src\\main\\resources\\FileUpload\\";
/*Expected data*/
/*LoginPage*/
public static final String EXPECTED_PAGE_URL = "https://erpqa.kerchanshe.biz/admin/mis_common_dashboard";
/*Expected data*/
/*CompanyMastersPage*/
public static final String EXPECTED_SEARCH_RESULT = "Buna Dhuga";
public static final String EXPECTED_DELETE_SEARCH_RESULT = "No matching records found";
public static final String EXPECTED_COMPANY_VIEW_PAGE_TITLE = "View Company";
public static final String EXPECTED_COMPANY_EDIT_TITLE="Edit Company";
public static final String EXPECTED_COMPANY_DOWNLOAD_PAGE_TITLE="Company Payroll";
/*DepartMasrtersPage*/
public static final String EXPECTED_DEPARTMENT_SEARCH_RESULT = "SoftwareTesting";
public static final String EXPECTED_DEPARTMENT_DELETE_SEARCH_RESULT = "No matching records found";
public static final String EXPECTED_EDIT_ELEMENT_TITLE= "Edit Department";
public static final String EXPECTED_VIEW_PAGE_TITLE= "View Department";
/*DesignationMastersPage*/
public static final String EXPECTED_DESIGNATION_SEARCH_RESULT = "test lead";
public static final String EXPECTED_DESIGNATION_DELETE_SEARCH_RESULT = "No matching records found";
public static final String EXPECTED_DESIGNATION_EDIT_PAGE_TITLE="Edit Designation";
public static final String EXPECTED_DESIGNATION_VIEW_PAGE_TITLE="View Designation";
/*CityMastersPage*/
public static final String EXPECTED_CITY_SEARCH_RESULT = "Japan";
public static final String EXPECTED_CITY_DELETE_SEARCH_RESULT = "No matching records found";
public static final String EXPECTED_CITY_EDIT_PAGE_TITLE="Edit City and SubCity";
public static final String EXPECTED_CITY_VIEW_PAGE_TITLE="View City and SubCity";
}