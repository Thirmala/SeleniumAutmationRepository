package GenericFileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	FileInputStream fis ;
	public String getDataFromExcel(String sheetName, int rowNum, int celNum) throws Exception, IOException  {
 fis = new FileInputStream("./testScriptData/OrgTestScript.xlsx");
		
//		step 2 : open Workbook in read mode
		Workbook wb =WorkbookFactory.create(fis);
	String value=	wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).toString();
	wb.close();
	//WE HAVE TO CLOSE EXCEL BECAUSE MORE EXCEL SHEETS WILL GET OPENED , IF WE EXECUTE MANY TIMES
	return value;
	}
	
	public String getDataFromExcelContact(String sheetName, int rowNum, int celNum) throws Exception, IOException  {
		 fis = new FileInputStream("./testScriptData/ContactWithOrgName.xlsx");
				
//				step 2 : open Workbook in read mode
				Workbook wb =WorkbookFactory.create(fis);
			String value=	wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).toString();
			wb.close();
			//WE HAVE TO CLOSE EXCEL BECAUSE MORE EXCEL SHEETS WILL GET OPENED , IF WE EXECUTE MANY TIMES
			return value;
			}
	
	
	//GET LASTROWNUM
	public int getRowCount(String sheetName) throws Exception{
fis = new FileInputStream("./testScriptData/OrgTestScript.xlsx");
		
		Workbook wb =WorkbookFactory.create(fis);
	int lastRowNum=	wb.getSheet(sheetName).getLastRowNum();
	wb.close();
	return lastRowNum;
	}
	
	//GET LASTROWNUM
	public void setDataIntoExcel(String sheetName, int rowNum, int celNum, String Data) throws Exception {
		 fis = new FileInputStream("./testScriptData/OrgTestScript.xlsx");
				
//				step 2 : open Workbook in read mode
				Workbook wb =WorkbookFactory.create(fis);
				//to send value to particular cell
			wb.getSheet(sheetName).getRow(rowNum).createCell(celNum);
			 
			
			FileOutputStream fos = new FileOutputStream("./testScriptData/OrgTestScript.xlsx");
			wb.write(fos);
			wb.close();
			}
			

	}
		
	
	

