package com.mla.testCases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.mla.base.BaseTest;

import utilities.ExcelReader;

public class Test2 extends BaseTest {

	// WebDriver driver;
	String path;
	static ExcelReader excel;
	String sheet_TestCases = "TestCases";
	String sheet_TestData = "TestData";

	@Test
	public void TC_MyCar_02() throws Exception {

		path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\mla\\resources\\testData.xlsx";
		excel = new ExcelReader(path);
		Thread.sleep(3000);
		
		String testcaseID="TC_MyCar_02";
		boolean isSkip=false;
		try {
			int rowNumber=excel.getFirstDataRowNum(sheet_TestCases, "TCID", testcaseID);
			String runMode=excel.getCellData(sheet_TestCases, "Run", rowNumber);
			if(runMode.contains("No")||runMode.isEmpty()) {
				isSkip=true;
			}
			if(isSkip) {
				throw new SkipException("Skip this test case"+testcaseID);
			}
			int rowNum=excel.getRowNum(sheet_TestData, testcaseID);
			String expectedTitle=excel.getCellData(sheet_TestData, "TestData1", rowNum);
					String actualTitle = hp.getPageTitile();
					if (actualTitle.equals(expectedTitle)) {
						System.out.println("Test case pass actual title maches with expected");
					excel.setCellData(sheet_TestCases, testcaseID, "Result", "PASS");
					}
					else {
						excel.setCellData(sheet_TestCases, testcaseID, "Result", "FAIL");
						//throw new Exception("Test case fail actual title is not maches with expected");
						
					}
				
		}catch(Exception e) {
			if(isSkip) {
				excel.setCellData(sheet_TestCases, testcaseID, "Result", "SKIP");
			}
			throw e;
		}
	}
}

		
