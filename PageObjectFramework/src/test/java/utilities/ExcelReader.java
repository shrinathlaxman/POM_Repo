package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public FileInputStream fis;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFRow row;
	private XSSFCell cell;
	String path;

	public ExcelReader(String path) {

		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		workbook = new XSSFWorkbook();
		sheet = workbook.getSheetAt(0);
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getRowCount(String sheetName) {

		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		int count = sheet.getLastRowNum() + 1;
		return count;
	}

	public int getRowNum(String sheetName, String testcaseName) {
		try {
			int index = workbook.getSheetIndex(sheetName);
			int row_Num = 0;
			sheet = workbook.getSheetAt(index);
			int rowCount = getRowCount(sheetName);
			for (int i = 0; i < rowCount; i++) {
				cell = sheet.getRow(i).getCell(0);
				if (!cell.getStringCellValue().equals("")) {
					if (cell.getStringCellValue().trim().equals(testcaseName.trim())) {
						row_Num = i;
					}
				}
			}
			return row_Num;
		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
	}

	public String getCellData(String sheetName, String colName, int rowNum) {

		int index = workbook.getSheetIndex(sheetName);
		int col_Num = 0;
		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(0);
		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(colName.trim())) {
				col_Num = i;
				break;
			}
		}

		row = sheet.getRow(rowNum);
		cell = row.getCell(col_Num);
		return cell.getStringCellValue();
	}

	public int getRowCount(String sheetName, String colName, String methodName) {

		ArrayList<Integer> rows = new ArrayList<Integer>();
		for (int i = 1; i < getRowCount(sheetName); i++) {
			String tcid = getCellData(sheetName, colName, i);
			if (tcid.equals(methodName)) {
				rows.add(i);
			}
		}
		return rows.size();
	}

	public int getColumnCount(String sheetName) {
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		return row.getLastCellNum();
	}

	public int getColumnNumber(String sheetName, String colName) {
		// To get the column count in the specific sheet
		XSSFRow row = sheet.getRow(0);
		int colCount = row.getLastCellNum();

		// To get the data from the specified col and row num
		int colNum = 0;
		for (int i = 0; i < colCount; i++) {
			if (row.getCell(i).getStringCellValue().equals(colName)) {
				colNum = i;
				break;
			}
		}
		return colNum;
	}

	public int getFirstDataRowNum(String sheetName, String colName, String methodName) {

		for (int i = 1; i < getRowCount(sheetName); i++) {
			String tcid = getCellData(sheetName, colName, i);
			if (tcid.equals(methodName)) {
				return i;
			}
		}
		return -1;
	}

	// Set cell data based on the test case id and column Name

	public void setCellData(String sheetName, String testcaseName, String columnName, String status)
			throws IOException {
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		int rowCount = sheet.getLastRowNum() + 1;

		int caseRowNumber = getRowNum(sheetName, testcaseName);
		int colNumber = getColumnNumber(sheetName, columnName);
		sheet.getRow(caseRowNumber).createCell(colNumber).setCellValue(status);
		FileOutputStream fileOutput = new FileOutputStream(path);
		workbook.write(fileOutput);
		fileOutput.close();

	}

}
